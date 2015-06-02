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
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
import com.mutual.modelo.Itinerario;
import com.mutual.modelo.Persona;
import com.mutual.modelo.Sistema;
import com.mutual.modelo.Ticket;
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
		"/com/mutual/vista/login.fxml", anchorPane,
		"Turismo  -  Mutual de Petroleros Jerarquicos",
		"file:recursos/imagenes/logoMutual.png");
	ControladorLogin ctrlLogin = loader.getController();
	ctrlLogin.setPrincipal(this);
	ctrlLogin.setEscenario(escenarioPrincipal);
	login.show();
    }

    public void cargarVentanaPantallaPrincipal() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage pantallaPrincipal = cargarVentana(escenarioPrincipal, loader,
		"/com/mutual/vista/pantallaPrincipal.fxml", anchorPane,
		" (Usuario: " + usuarioActivo.getUsuario() + ")",
		"file:recursos/imagenes/logoMutual.png");
	ControladorPantallaPrincipal ctrlPantallaPrincipal = loader
		.getController();
	ctrlPantallaPrincipal.setPrincipal(this);
	ctrlPantallaPrincipal.setEscenario(escenarioPrincipal);
	pantallaPrincipal.show();
    }

    voadsasd
    
    public void cargarVentanaAeropuertoArgentina() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	
	AnchorPane anchorTransferir = (AnchorPane) loader.load();
	Stage escenarioAA = new Stage();
	escenarioAA = cargarVentana(escenarioAA, loader,
		"/com/mutual/vista/aeropuertoArgentina.fxml", anchorTransferir);
	escenarioAA.setResizable(false);
	escenarioAA.sizeToScene();
	Scene escena = new Scene(anchorTransferir);
	escenarioAA.setScene(escena);
	ControladorAeropuertoArgentina controladorAA = loader.getController();
	controladorAA.setEscenario(escenarioAA);
	escenarioAA.show();

    }

    public void cargarVentanaTicket(TipoVentana tipoVentana,
	    TableView<TicketProperty> tabla, long numeroTicket)
	    throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Utilidades
		.restToURL("/com/mutual/vista/ticket.fxml"));
	AnchorPane anchorTransferir = (AnchorPane) loader.load();
	Stage escenarioTicket = new Stage();
	escenarioTicket.setResizable(false);
	escenarioTicket.sizeToScene();
	Scene escena = new Scene(anchorTransferir);
	escenarioTicket.setScene(escena);
	ControladorTicket controladorTicket = loader.getController();
	controladorTicket.setTipoVentana(tipoVentana);
	controladorTicket.setPrincipal(this);
	controladorTicket.setTabla(tabla);
	if (tipoVentana == TipoVentana.UPDATE) {
	    escenarioTicket.getIcons().add(
		    new Image("file:recursos/imagenes/update.png"));
	    Session session = HibernateUtil.getSessionFactory()
		    .getCurrentSession();
	    try {
		session.beginTransaction();
		Ticket ticket = (Ticket) session
			.get(Ticket.class, numeroTicket);
		controladorTicket.getACFieldDniPasajero().setText(
			Integer.toString(ticket.getPasajero().getDni()));
		controladorTicket.getACFieldDniPasajero().setEditable(false);
		controladorTicket.getACFieldDniSolicitante().setText(
			Integer.toString(ticket.getSolicitante().getDni()));
		controladorTicket.getACFieldDniPasajero().setEditable(false);
		for (Itinerario it : ticket.getItinerarios()) {
		    controladorTicket
			    .getListViewItinerario()
			    .getItems()
			    .add(it.getCodigoAeropuerto() + " "
				    + it.getNombreAeropuerto());
		}
		controladorTicket.getFieldApellidoPasajero().setText(
			ticket.getPasajero().getApellido());
		controladorTicket.getFieldApellidoSolicitante().setText(
			ticket.getSolicitante().getApellido());
		controladorTicket.getFieldEmisor().setText(
			ticket.getUsuario().getUsuario());
		controladorTicket.getFieldImpuestos().setText(
			Float.toString(ticket.getImpuesto()));
		controladorTicket.getFieldNombrePasajero().setText(
			ticket.getPasajero().getNombre());
		controladorTicket.getFieldNombreSolicitante().setText(
			ticket.getSolicitante().getNombre());
		controladorTicket.getFieldNumeroTicket().setText(
			Long.toString(numeroTicket));
		controladorTicket.getFieldTarifaBase().setText(
			Float.toString(ticket.getTarifaBase()));
		controladorTicket.getDatePickerEmision().setValue(
			LocalDateTime.ofInstant(
				Instant.ofEpochMilli((ticket.getFechaEmision())
					.getTime()), ZoneId.systemDefault())
				.toLocalDate());
		controladorTicket.getDatePickerVuelo().setValue(
			LocalDateTime.ofInstant(
				Instant.ofEpochMilli((ticket.getFechaViaje())
					.getTime()), ZoneId.systemDefault())
				.toLocalDate());
		controladorTicket.getCheckBoxIdaVuelta().setSelected(
			ticket.isIdaVuelta());
		controladorTicket.getFieldNumeroTicket().setEditable(false);
		controladorTicket.getFieldApellidoPasajero().setEditable(false);
		controladorTicket.getFieldApellidoSolicitante().setEditable(
			false);
		controladorTicket.getFieldNombrePasajero().setEditable(false);
		controladorTicket.getFieldNombreSolicitante()
			.setEditable(false);
		controladorTicket.getFieldNumeroTicket().setEditable(false);

		session.getTransaction().commit();
	    } catch (Exception e) {
		if (session.getTransaction() == null) {
		    session.getTransaction().rollback();
		}
	    }
	}
	escenarioTicket.setTitle("Ticket de Pasajero");
	escenarioTicket.getIcons().add(
		new Image("file:recursos/imagenes/addTicket.png"));
	controladorTicket.getFieldEmisor().setText(usuarioActivo.getUsuario());
	controladorTicket.getFieldEmisor().setEditable(false);
	controladorTicket.setEscenario(escenarioTicket);
	controladorTicket.getImageError().setImage(
		new Image("file:recursos/imagenes/error.png"));
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

	    // TODO: handle exception
	}

    }

    private Stage cargarVentana(Stage escenario, FXMLLoader loader,
	    String urlFXML, AnchorPane layoutPrincipal, String title,
	    String urlImage) throws Exception {
	loader.setLocation(Utilidades.restToURL(urlFXML));
	layoutPrincipal = loader.load();
	Pane panel = (Pane) layoutPrincipal;
	Scene escena = new Scene(panel);
	escenario.setScene(escena);
	escenario.setResizable(false);
	escenario.sizeToScene();
	escenario.setTitle(title);
	escenario.getIcons().add(new Image(urlImage));
	return escenario;
    }

    private Stage cargarVentana(Stage escenario, FXMLLoader loader,
	    String urlFXML, AnchorPane layoutPrincipal) throws Exception {
	loader.setLocation(Utilidades.restToURL(urlFXML));
	layoutPrincipal = loader.load();
	Pane panel = (Pane) layoutPrincipal;
	Scene escena = new Scene(panel);
	escenario.setScene(escena);
	escenario.setResizable(false);
	escenario.sizeToScene();
	return escenario;
    }

}
