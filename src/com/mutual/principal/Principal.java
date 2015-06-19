package com.mutual.principal;

import java.util.ArrayList;

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

import com.mutual.controlador.ControladorAeropuertoArgentina;
import com.mutual.controlador.ControladorFechasInicioFin;
import com.mutual.controlador.ControladorLogin;
import com.mutual.controlador.ControladorPantallaPrincipal;
import com.mutual.controlador.ControladorSocio;
import com.mutual.controlador.ControladorTicket;
import com.mutual.enumerado.TipoVentana;
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

    public void cargarVentanaFechaInicioFin() throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage escenarioFechas;
	escenarioFechas = cargarVentana(new Stage(), loader,
		"/com/mutual/vista/fechasInicioFin.fxml", "Buscar Tickets",
		"file:recursos/imagenes/calendario.png");
	ControladorFechasInicioFin controladorFecha = loader.getController();
	controladorFecha.setEscenario(escenarioFechas);
	escenarioFechas.show();

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
	if (tipoVentana == TipoVentana.BUSCAR) {
	    System.out.println("Ingresó al buscar");
	    Long nroTicket = controladorTicket.ventanaBuscar();
	    if (Sistema.getSistema().existeTicket(nroTicket)) {
		System.out.println("El ticket Existe");
		controladorTicket.setNumeroTicket(nroTicket);
		controladorTicket.traerDatos();
	    }

	}
	controladorTicket.inicializar();
	escenarioTicket = centrarVentana(escenarioTicket,
		controladorTicket.getAnchorPane());
	escenarioTicket.show();

    }

    public void cargarVentanaSocio(TipoVentana tipoVentana,
	    ArrayList<Integer> personasNuevas) throws Exception {
	FXMLLoader loader = new FXMLLoader();
	Stage escenarioSocio = cargarVentana(new Stage(), loader,
		"/com/mutual/vista/socio.fxml");
	ControladorSocio controladorSocio = loader.getController();
	controladorSocio.setEscenario(escenarioSocio);
	controladorSocio.setPersonasNuevas(personasNuevas);
	controladorSocio.setTipoVentana(tipoVentana);
	controladorSocio.setPrincipal(this);
	if (tipoVentana == TipoVentana.UPDATE) {
	    controladorSocio.traerDatosUpdate();
	} else if (tipoVentana == TipoVentana.NUEVA) {
	    controladorSocio.nuevaVentana();
	} else if (tipoVentana == TipoVentana.BUSCAR) {
	    String dniBuscar = controladorSocio.ventanaBuscar();
	    if (Sistema.getSistema().existePersona(Integer.parseInt(dniBuscar))) {
		controladorSocio.getPersonasNuevas().add(
			Integer.parseInt(dniBuscar));
		controladorSocio.traerDatosUpdate();
		controladorSocio.setTipoVentana(TipoVentana.UPDATE);
	    }
	}

	escenarioSocio.show();

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
