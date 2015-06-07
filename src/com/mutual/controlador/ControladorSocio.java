package com.mutual.controlador;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import org.controlsfx.dialog.DialogStyle;
import org.controlsfx.dialog.Dialogs;
import org.hibernate.Session;

import com.mutual.enumerado.TipoVentana;
import com.mutual.modelo.Persona;
import com.mutual.principal.Principal;
import com.mutual.util.HibernateUtil;
import com.mutual.util.Utilidades;

public class ControladorSocio {

    @FXML
    private TextField fieldDomicilio2;

    @FXML
    private TextField fieldDomicilio1;

    @FXML
    private TextField fieldCorreo2;

    @FXML
    private Tab tab1;

    @FXML
    private TextField fieldCorreo1;

    @FXML
    private Tab tab2;

    @FXML
    private Button cancelar1;

    @FXML
    private TextField fieldNombre2;

    @FXML
    private TextField fieldNombre1;

    @FXML
    private Button cancelar2;

    @FXML
    private TextField fieldTelefono2;

    @FXML
    private TextField fieldOcupación2;

    @FXML
    private TextField fieldOcupación1;

    @FXML
    private TextField fieldTelefono1;

    @FXML
    private DatePicker datePickerNacimiento1;

    @FXML
    private DatePicker datePickerAlta1;

    @FXML
    private DatePicker datePickerNacimiento2;

    @FXML
    private DatePicker datePickerAlta2;

    @FXML
    private TextField fieldDni1;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField fieldDni2;

    @FXML
    private TextField fieldEmpresa1;

    @FXML
    private TextField fieldEmpresa2;

    @FXML
    private TextField fieldApellido1;

    @FXML
    private Button buttonGuardar1;

    @FXML
    private Button buttonGuardar2;

    @FXML
    private TextField fieldApellido2;

    private Stage escenario;

    private ArrayList<Integer> personasNuevas;

    private TipoVentana tipoVentana;

    private Principal principal;

    public Principal getPrincipal() {
	return principal;
    }

    public void setPrincipal(Principal principal) {
	this.principal = principal;
    }

    public TipoVentana getTipoVentana() {
	return tipoVentana;
    }

    public void setTipoVentana(TipoVentana tipoVentana) {
	this.tipoVentana = tipoVentana;
    }

    public ArrayList<Integer> getPersonasNuevas() {
	return personasNuevas;
    }

    public void setPersonasNuevas(ArrayList<Integer> personasNuevas) {
	this.personasNuevas = personasNuevas;
    }

    public Stage getEscenario() {
	return escenario;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

    public TabPane getTabPane() {
	return tabPane;
    }

    public void setTabPane(TabPane tabPane) {
	this.tabPane = tabPane;
    }

    public TextField getFieldDomicilio2() {
	return fieldDomicilio2;
    }

    public void setFieldDomicilio2(TextField fieldDomicilio2) {
	this.fieldDomicilio2 = fieldDomicilio2;
    }

    public TextField getFieldDomicilio1() {
	return fieldDomicilio1;
    }

    public void setFieldDomicilio1(TextField fieldDomicilio1) {
	this.fieldDomicilio1 = fieldDomicilio1;
    }

    public TextField getFieldCorreo2() {
	return fieldCorreo2;
    }

    public void setFieldCorreo2(TextField fieldCorreo2) {
	this.fieldCorreo2 = fieldCorreo2;
    }

    public Tab getTab1() {
	return tab1;
    }

    public void setTab1(Tab tab1) {
	this.tab1 = tab1;
    }

    public TextField getFieldCorreo1() {
	return fieldCorreo1;
    }

    public void setFieldCorreo1(TextField fieldCorreo1) {
	this.fieldCorreo1 = fieldCorreo1;
    }

    public Tab getTab2() {
	return tab2;
    }

    public void setTab2(Tab tab2) {
	this.tab2 = tab2;
    }

    public Button getCancelar1() {
	return cancelar1;
    }

    public void setCancelar1(Button cancelar1) {
	this.cancelar1 = cancelar1;
    }

    public TextField getFieldNombre2() {
	return fieldNombre2;
    }

    public void setFieldNombre2(TextField fieldNombre2) {
	this.fieldNombre2 = fieldNombre2;
    }

    public TextField getFieldNombre1() {
	return fieldNombre1;
    }

    public void setFieldNombre1(TextField fieldNombre1) {
	this.fieldNombre1 = fieldNombre1;
    }

    public Button getCancelar2() {
	return cancelar2;
    }

    public void setCancelar2(Button cancelar2) {
	this.cancelar2 = cancelar2;
    }

    public TextField getFieldTelefono2() {
	return fieldTelefono2;
    }

    public void setFieldTelefono2(TextField fieldTelefono2) {
	this.fieldTelefono2 = fieldTelefono2;
    }

    public TextField getFieldOcupación2() {
	return fieldOcupación2;
    }

    public void setFieldOcupación2(TextField fieldOcupación2) {
	this.fieldOcupación2 = fieldOcupación2;
    }

    public TextField getFieldOcupación1() {
	return fieldOcupación1;
    }

    public void setFieldOcupación1(TextField fieldOcupación1) {
	this.fieldOcupación1 = fieldOcupación1;
    }

    public TextField getFieldTelefono1() {
	return fieldTelefono1;
    }

    public void setFieldTelefono1(TextField fieldTelefono1) {
	this.fieldTelefono1 = fieldTelefono1;
    }

    public DatePicker getDatePickerNacimiento1() {
	return datePickerNacimiento1;
    }

    public void setDatePickerNacimiento1(DatePicker datePickerNacimiento1) {
	this.datePickerNacimiento1 = datePickerNacimiento1;
    }

    public DatePicker getDatePickerAlta1() {
	return datePickerAlta1;
    }

    public void setDatePickerAlta1(DatePicker datePickerAlta1) {
	this.datePickerAlta1 = datePickerAlta1;
    }

    public DatePicker getDatePickerNacimiento2() {
	return datePickerNacimiento2;
    }

    public void setDatePickerNacimiento2(DatePicker datePickerNacimiento2) {
	this.datePickerNacimiento2 = datePickerNacimiento2;
    }

    public DatePicker getDatePickerAlta2() {
	return datePickerAlta2;
    }

    public void setDatePickerAlta2(DatePicker datePickerAlta2) {
	this.datePickerAlta2 = datePickerAlta2;
    }

    public TextField getFieldDni1() {
	return fieldDni1;
    }

    public void setFieldDni1(TextField fieldDni1) {
	this.fieldDni1 = fieldDni1;
    }

    public TextField getFieldDni2() {
	return fieldDni2;
    }

    public void setFieldDni2(TextField fieldDni2) {
	this.fieldDni2 = fieldDni2;
    }

    public TextField getFieldEmpresa1() {
	return fieldEmpresa1;
    }

    public void setFieldEmpresa1(TextField fieldEmpresa1) {
	this.fieldEmpresa1 = fieldEmpresa1;
    }

    public TextField getFieldEmpresa2() {
	return fieldEmpresa2;
    }

    public void setFieldEmpresa2(TextField fieldEmpresa2) {
	this.fieldEmpresa2 = fieldEmpresa2;
    }

    public TextField getFieldApellido1() {
	return fieldApellido1;
    }

    public void setFieldApellido1(TextField fieldApellido1) {
	this.fieldApellido1 = fieldApellido1;
    }

    public Button getButtonGuardar1() {
	return buttonGuardar1;
    }

    public void setButtonGuardar1(Button buttonGuardar1) {
	this.buttonGuardar1 = buttonGuardar1;
    }

    public Button getButtonGuardar2() {
	return buttonGuardar2;
    }

    public void setButtonGuardar2(Button buttonGuardar2) {
	this.buttonGuardar2 = buttonGuardar2;
    }

    public TextField getFieldApellido2() {
	return fieldApellido2;
    }

    public void setFieldApellido2(TextField fieldApellido2) {
	this.fieldApellido2 = fieldApellido2;
    }

    @FXML
    void guardarPersona1(ActionEvent event) {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	try {
	    session.beginTransaction();
	    if (tipoVentana == TipoVentana.UPDATE) {

		Persona p1 = (Persona) session.get(Persona.class,
			Integer.parseInt(fieldDni1.getText()));

		cargarDatosEnPersona(p1, fieldApellido1, fieldNombre1,
			fieldDni1, fieldCorreo1, fieldDomicilio1,
			fieldEmpresa1, fieldOcupación1, fieldTelefono1,
			datePickerAlta1, datePickerNacimiento1);

		session.update(p1);
		tabPane.getTabs().remove(0);
	    } else if (tipoVentana == TipoVentana.NUEVA) {
		Persona persona = new Persona();
		cargarDatosEnPersona(persona, fieldApellido1, fieldNombre1,
			fieldDni1, fieldCorreo1, fieldDomicilio1,
			fieldEmpresa1, fieldOcupación1, fieldTelefono1,
			datePickerAlta1, datePickerNacimiento1);

		session.save(persona);
		salir();

	    } else if (tipoVentana == TipoVentana.BUSCAR) {

		Persona personaBuscar = (Persona) session.get(Persona.class,
			Integer.parseInt(fieldDni1.getText()));

		cargarDatosEnPersona(personaBuscar, fieldApellido1,
			fieldNombre1, fieldDni1, fieldCorreo1, fieldDomicilio1,
			fieldEmpresa1, fieldOcupación1, fieldTelefono1,
			datePickerAlta1, datePickerNacimiento1);

		session.update(personaBuscar);
		salir();

	    }

	    session.getTransaction().commit();
	    HibernateUtil.traerPersonasBase();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    throw e;
	}

    }

    @FXML
    void guardarPersona2(ActionEvent event) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
	    session.beginTransaction();
	    Persona p2 = (Persona) session.get(Persona.class,

	    Integer.parseInt(fieldDni2.getText()));
	    cargarDatosEnPersona(p2, fieldApellido2, fieldNombre2, fieldDni2,
		    fieldCorreo2, fieldDomicilio2, fieldEmpresa2,
		    fieldOcupación2, fieldTelefono2, datePickerAlta2,
		    datePickerNacimiento2);

	    session.getTransaction().commit();
	    salir();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    throw e;
	}
    }

    @FXML
    void salir() {
	escenario.close();
    }

    public void traerDatosUpdate() {
	escenario.setTitle("Actualizar datos");
	escenario.getIcons().add(
		new Image("file:recursos/imagenes/updatePersona.png"));
	fieldDni1.setEditable(false);
	fieldDni2.setEditable(false);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	System.out.println("Personas nuevas: " + personasNuevas.size());
	for (Integer dni : personasNuevas) {
	    System.out.println(dni);
	}

	if (personasNuevas.size() == 1) {
	    try {
		System.out.println("UNA PERSONA NueVA");
		session.beginTransaction();

		Persona per = (Persona) session.get(Persona.class,
			personasNuevas.get(0));
		cargarDatosEnComponentes(per, fieldApellido1, fieldNombre1,
			fieldDni1, fieldCorreo1, fieldDomicilio1,
			fieldEmpresa1, fieldOcupación1, fieldTelefono1,
			datePickerAlta1, datePickerNacimiento1);
		tabPane.getTabs().remove(1);
		tab1.setText("");
		session.getTransaction().commit();
		escenario.setTitle("Socios");
		escenario.getIcons().add(
			new Image("file:recursos/imagenes/addTicket.png"));

	    } catch (Exception e) {
		session.getTransaction().rollback();
		System.out.println("Se la mandó");
	    }

	} else if (personasNuevas.size() == 2) {
	    System.out.println("Personas nuevas: " + personasNuevas.size());
	    for (Integer dni : personasNuevas) {
		System.out.println(dni);
	    }
	    try {
		System.out.println("DOS PERSONAS NUEVAS");
		session.beginTransaction();
		Persona p1 = (Persona) session.get(Persona.class,
			personasNuevas.get(0));
		Persona p2 = (Persona) session.get(Persona.class,
			personasNuevas.get(1));

		cargarDatosEnComponentes(p1, fieldApellido1, fieldNombre1,
			fieldDni1, fieldCorreo1, fieldDomicilio1,
			fieldEmpresa1, fieldOcupación1, fieldTelefono1,
			datePickerAlta1, datePickerNacimiento1);
		cargarDatosEnComponentes(p2, fieldApellido2, fieldNombre2,
			fieldDni2, fieldCorreo2, fieldDomicilio2,
			fieldEmpresa2, fieldOcupación2, fieldTelefono2,
			datePickerAlta2, datePickerNacimiento2);

		session.getTransaction().commit();

	    } catch (Exception e) {
		session.getTransaction().rollback();
	    }
	}

    }

    private void cargarDatosEnComponentes(Persona persona, TextField apellido,
	    TextField nombre, TextField dni, TextField correo,
	    TextField domicilio, TextField empresa, TextField ocupacion,
	    TextField telefono, DatePicker alta, DatePicker nacimiento) {
	apellido.setText(persona.getApellido());
	nombre.setText(persona.getNombre());
	dni.setText(Integer.toString(persona.getDni()));
	correo.setText(persona.getMail());
	domicilio.setText(persona.getDomicilio());
	empresa.setText(persona.getEmpresa());
	ocupacion.setText(persona.getOcupacion());
	telefono.setText(persona.getTelefono());
	alta.setValue(LocalDateTime.ofInstant(
		Instant.ofEpochMilli((persona.getFechaAlta()).getTime()),
		ZoneId.systemDefault()).toLocalDate());
	nacimiento.setValue(LocalDateTime.ofInstant(
		Instant.ofEpochMilli((persona.getFechaNacimiento()).getTime()),
		ZoneId.systemDefault()).toLocalDate());

    }

    private void cargarDatosEnPersona(Persona persona, TextField apellido,
	    TextField nombre, TextField dni, TextField correo,
	    TextField domicilio, TextField empresa, TextField ocupacion,
	    TextField telefono, DatePicker alta, DatePicker nacimiento) {
	persona.setApellido(apellido.getText());
	persona.setDni(Integer.parseInt(dni.getText()));
	persona.setDomicilio(domicilio.getText());
	persona.setEmpresa(empresa.getText());
	persona.setFechaAlta(Utilidades.datePickerToDate(alta));
	persona.setFechaNacimiento(Utilidades.datePickerToDate(nacimiento));
	persona.setMail(correo.getText());
	persona.setNombre(nombre.getText());
	persona.setOcupacion(ocupacion.getText());
	persona.setTelefono(telefono.getText());

    }

    public void nuevaVentana() {
	tabPane.getTabs().remove(1);
	escenario.setTitle("Nueva Persona");
	escenario.getIcons().add(
		new Image("file:recursos/imagenes/nuevaPersona.png"));
	tabPane.getTabs().get(0).setText("");
    }

    public String ventanaBuscar() {
	Stage stage = new Stage();
	stage.setX(0);
	Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	escenario.setX((primScreenBounds.getWidth() - (stage.getWidth())) / 2);
	escenario
		.setY((primScreenBounds.getHeight() - (stage.getHeight())) / 4);

	Optional<String> response = Dialogs.create().owner(stage)
		.title("Buscar Socio").style(DialogStyle.NATIVE)
		.masthead("Ingrese el dni del socio ").message("DNI:")
		.showTextInput("numero de documento");
	return response.get();
    }

}