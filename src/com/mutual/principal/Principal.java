package com.mutual.principal;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.controlsfx.dialog.DialogStyle;
import org.controlsfx.dialog.Dialogs;
import org.hibernate.Session;

import com.mutual.controlador.ControladorAeropuertoArgentina;
import com.mutual.controlador.ControladorLogin;
import com.mutual.controlador.ControladorPantallaPrincipal;
import com.mutual.controlador.ControladorSocio;
import com.mutual.controlador.ControladorTicket;
import com.mutual.enumerado.TipoVentana;
import com.mutual.modelo.Persona;
import com.mutual.modelo.Sistema;
import com.mutual.modelo.Usuario;
import com.mutual.property.TicketProperty;
import com.mutual.util.CodigoAeropuerto;
import com.mutual.util.HibernateUtil;
import com.mutual.util.Utilidades;

public class Principal extends Application {

    /*
     * Atributos Principales
     */

    public Stage escenarioPrincipal;
    public AnchorPane anchorPane;
    public Usuario usuarioActivo;

    public static void main(String[] args) {
	Sistema.getSistema();
	HibernateUtil.getSessionFactory();
	HibernateUtil.traerDatosBase();

	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	CodigoAeropuerto.cargarCodigoAeropuerto();
	Sistema.getSistema().ActualizarlistaTicketProperty();

	this.escenarioPrincipal = primaryStage;
	primaryStage.setResizable(false);
	primaryStage.sizeToScene();
	cargarVentanaLogin();
	primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

	    public void handle(WindowEvent event) {
		HibernateUtil.getSessionFactory().close();
	    }
	});

    }

    public void cargarVentanaLogin() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage login = cargarVentana(escenarioPrincipal, loader,
		"/com/mutual/vista/login.fxml",
		"Turismo  -  Mutual de Petroleros Jerarquicos",
		"file:recursos/imagenes/logoMutual.png");
	ControladorLogin ctrlLogin = loader.getController();
	ctrlLogin.setPrincipal(this);
	ctrlLogin.setEscenario(escenarioPrincipal);
	login = centrarVentana(login, ctrlLogin.getAnchorPane());
	login.show();
    }

    public void cargarVentanaPantallaPrincipal() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage pantallaPrincipal = cargarVentana(escenarioPrincipal, loader,
		"/com/mutual/vista/pantallaPrincipal.fxml", " (Usuario: "
			+ usuarioActivo.getUsuario() + ")",
		"file:recursos/imagenes/logoMutual.png");
	ControladorPantallaPrincipal controladorPPrincipal = loader
		.getController();
	pantallaPrincipal = centrarVentana(pantallaPrincipal,
		controladorPPrincipal.getAnchorPane());
	controladorPPrincipal.setPrincipal(this);
	controladorPPrincipal.setEscenario(escenarioPrincipal);
	pantallaPrincipal.show();

    }

    public void cargarVentanaAeropuertoArgentina() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage escenarioAArgentina;
	escenarioAArgentina = cargarVentana(new Stage(), loader,
		"/com/mutual/vista/aeropuertoArgentina.fxml",
		"Aeropuerto Argentina 2000",
		"file:recursos/imagenes/aa2000.gif");
	ControladorAeropuertoArgentina controladorAArgentina = loader
		.getController();
	controladorAArgentina.setEscenario(escenarioAArgentina);
	escenarioAArgentina.show();

    }

    public void cargarVentanaTicket(TipoVentana tipoVentana,
	    TableView<TicketProperty> tabla, long numeroTicket)
	    throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage escenarioTicket = cargarVentana(new Stage(), loader,
		"/com/mutual/vista/ticket.fxml");

	ControladorTicket controladorTicket = loader.getController();
	controladorTicket.setTipoVentana(tipoVentana);
	controladorTicket.setPrincipal(this);
	controladorTicket.setTabla(tabla);
	controladorTicket.setNumeroTicket(numeroTicket);
	controladorTicket.setEscenario(escenarioTicket);
	if (tipoVentana == TipoVentana.UPDATE) {
	    controladorTicket.traerDatos();
	}
	controladorTicket.inicializar();
	escenarioTicket = centrarVentana(escenarioTicket,
		controladorTicket.getAnchorPane());
	escenarioTicket.show();

    }

    public void cargarVentanaSocio(TipoVentana tipoVentana,
	    ArrayList<Integer> personasNuevas) throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Utilidades.restToURL("/com/mutual/vista/socio.fxml"));
	AnchorPane anchorTransferir = (AnchorPane) loader.load();
	Stage escenarioSocio = new Stage();
	escenarioSocio.setResizable(false);
	escenarioSocio.sizeToScene();
	Scene escena = new Scene(anchorTransferir);
	escenarioSocio.setScene(escena);
	ControladorSocio controladorSocio = loader.getController();
	controladorSocio.setEscenario(escenarioSocio);
	controladorSocio.setPersonasNuevas(personasNuevas);
	controladorSocio.setTipoVentana(tipoVentana);
	if (tipoVentana == TipoVentana.UPDATE) {
	    escenarioSocio.setTitle("Actualizar datos");
	    escenarioSocio.getIcons().add(
		    new Image("file:recursos/imagenes/updatePersona.png"));
	    controladorSocio.getFieldDni1().setEditable(false);
	    controladorSocio.getFieldDni2().setEditable(false);

	    switch (personasNuevas.size()) {
	    case 1:
		Session session = HibernateUtil.getSessionFactory()
			.getCurrentSession();
		session.beginTransaction();

		Persona per = (Persona) session.get(Persona.class,
			personasNuevas.get(0));
		controladorSocio.getFieldDni1().setText(
			Integer.toString(per.getDni()));
		controladorSocio.getFieldApellido1().setText(per.getApellido());
		controladorSocio.getFieldNombre1().setText(per.getNombre());
		controladorSocio.getTabPane().getTabs().remove(1);
		controladorSocio.getTab1().setText("");
		session.getTransaction().commit();
		escenarioSocio.setTitle("Socios");
		escenarioSocio.getIcons().add(
			new Image("file:recursos/imagenes/addTicket.png"));
		escenarioSocio.show();
		break;
	    case 2:
		Persona p1 = Sistema.getSistema().buscarPersona(
			personasNuevas.get(0));
		Persona p2 = Sistema.getSistema().buscarPersona(
			personasNuevas.get(1));

		controladorSocio.getFieldApellido1().setText(p1.getApellido());
		controladorSocio.getFieldNombre1().setText(p1.getNombre());
		controladorSocio.getFieldDni1().setText(
			Integer.toString(p1.getDni()));

		controladorSocio.getFieldApellido2().setText(p2.getApellido());
		controladorSocio.getFieldNombre2().setText(p2.getNombre());
		controladorSocio.getFieldDni2().setText(
			Integer.toString(p2.getDni()));
		controladorSocio.getDatePickerNacimiento1().requestFocus();

		escenarioSocio.setTitle("Socios");
		escenarioSocio.getIcons().add(
			new Image("file:recursos/imagenes/addTicket.png"));
		escenarioSocio.show();
		break;
	    }

	} else if (tipoVentana == TipoVentana.NUEVA) {

	    controladorSocio.getTabPane().getTabs().remove(1);
	    escenarioSocio.setTitle("Nueva Persona");
	    escenarioSocio.getIcons().add(
		    new Image("file:recursos/imagenes/nuevaPersona.png"));
	    controladorSocio.getTabPane().getTabs().get(0).setText("");

	} else if (tipoVentana == TipoVentana.BUSCAR) {

	    // Sistema.getSistema().buscarPersona(dni);

	}

	escenarioSocio.show();

    }

    public void buscarPersona() {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
	    Stage stage = new Stage();
	    stage.setX(0);
	    Optional<String> response = Dialogs.create().owner(stage)
		    .title("Buscar Socio").style(DialogStyle.NATIVE)
		    .masthead("Ingrese el dni del socio ").message("DNI:")
		    .showTextInput("numero de documento");

	    if (Sistema.getSistema().existePersona(
		    Integer.parseInt(response.get()))) {
		session.beginTransaction();

		Persona p = (Persona) session.get(Persona.class,
			Integer.parseInt(response.get()));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Utilidades
			.restToURL("/com/mutual/vista/socio.fxml"));
		AnchorPane anchorTransferir = (AnchorPane) loader.load();
		Stage escenarioSocio = new Stage();
		escenarioSocio.setResizable(false);
		escenarioSocio.sizeToScene();
		Scene escena = new Scene(anchorTransferir);
		escenarioSocio.setScene(escena);

		ControladorSocio controladorSocio = loader.getController();
		controladorSocio.setEscenario(escenarioSocio);
		controladorSocio.setTipoVentana(TipoVentana.UPDATE);
		controladorSocio.getFieldApellido2().setText(p.getApellido());
		controladorSocio.getFieldCorreo2().setText(p.getMail());
		controladorSocio.getFieldDni2().setText(
			Integer.toString(p.getDni()));
		controladorSocio.getFieldDomicilio2().setText(p.getDomicilio());
		controladorSocio.getFieldEmpresa2().setText(p.getEmpresa());
		controladorSocio.getFieldNombre2().setText(p.getNombre());
		controladorSocio.getFieldOcupación2().setText(p.getOcupacion());
		controladorSocio.getFieldTelefono2().setText(p.getTelefono());
		controladorSocio.getDatePickerAlta2().setValue(
			LocalDateTime.ofInstant(
				Instant.ofEpochMilli((p.getFechaAlta())
					.getTime()), ZoneId.systemDefault())
				.toLocalDate());
		controladorSocio.getDatePickerNacimiento2().setValue(
			LocalDateTime.ofInstant(
				Instant.ofEpochMilli((p.getFechaNacimiento())
					.getTime()), ZoneId.systemDefault())
				.toLocalDate());
		controladorSocio.getTab2().setText("");

		controladorSocio.setDatePickerAlta2(Utilidades
			.dateToDatePicker(p.getFechaAlta()));
		controladorSocio.setDatePickerNacimiento2(Utilidades
			.dateToDatePicker(p.getFechaNacimiento()));
		controladorSocio.getTabPane().getTabs().remove(0);
		session.getTransaction().commit();
		escenarioSocio.setTitle("Socio");
		escenarioSocio.show();

	    }

	    response.ifPresent(name -> System.out.println("Your name: " + name));

	} catch (Exception e) {
	    session.getTransaction().rollback();
	    System.out.println("Excepcion saltada");

	}

    }

    private Stage cargarVentana(Stage escenario, FXMLLoader loader,
	    String urlFXML, String title, String urlImage) throws Exception {
	loader.setLocation(Utilidades.restToURL(urlFXML));
	Scene escena = new Scene((Pane) loader.load());
	escenario.setScene(escena);
	escenario.setResizable(false);
	escenario.sizeToScene();
	escenario.setTitle(title);
	escenario.getIcons().add(new Image(urlImage));
	return escenario;
    }

    private Stage cargarVentana(Stage escenario, FXMLLoader loader,
	    String urlFXML) throws Exception {
	loader.setLocation(Utilidades.restToURL(urlFXML));
	Scene escena = new Scene((Pane) loader.load());
	escenario.setScene(escena);
	escenario.setResizable(false);
	escenario.sizeToScene();
	return escenario;
    }

    private Stage centrarVentana(Stage escenario, Pane pane) {
	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	escenario
		.setX((primScreenBounds.getWidth() - (pane.getPrefWidth())) / 2);
	escenario
		.setY((primScreenBounds.getHeight() - (pane.getPrefHeight())) / 4);
	return escenario;
    }

}
