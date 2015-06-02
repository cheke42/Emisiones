package com.mutual.controlador;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.hibernate.Session;

import com.mutual.enumerado.TipoVentana;
import com.mutual.modelo.Persona;
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
		p1.setApellido(fieldApellido1.getText());
		p1.setDomicilio(fieldDomicilio1.getText());
		p1.setEmpresa(fieldEmpresa1.getText());
		p1.setFechaAlta(Utilidades.datePickerToDate(datePickerAlta1));
		p1.setFechaNacimiento(Utilidades
			.datePickerToDate(datePickerNacimiento1));
		p1.setMail(fieldCorreo1.getText());
		p1.setNombre(fieldNombre1.getText());
		p1.setOcupacion(fieldOcupación1.getText());
		p1.setTelefono(fieldTelefono1.getText());
		session.update(p1);
		tabPane.getTabs().remove(0);
	    } else if (tipoVentana == TipoVentana.NUEVA) {
		Persona persona = new Persona();
		persona.setApellido(fieldApellido1.getText());
		persona.setDni(Integer.parseInt(fieldDni1.getText()));
		persona.setDomicilio(fieldDomicilio1.getText());
		persona.setEmpresa(fieldEmpresa1.getText());
		persona.setFechaAlta(Utilidades
			.datePickerToDate(datePickerAlta1));
		persona.setFechaNacimiento(Utilidades
			.datePickerToDate(datePickerNacimiento1));
		persona.setMail(fieldCorreo1.getText());
		persona.setNombre(fieldNombre1.getText());
		persona.setOcupacion(fieldOcupación1.getText());
		persona.setTelefono(fieldTelefono1.getText());
		session.save(persona);
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
	    p2.setApellido(fieldApellido2.getText());
	    p2.setDomicilio(fieldDomicilio2.getText());
	    p2.setEmpresa(fieldEmpresa2.getText());
	    p2.setFechaAlta(Utilidades.datePickerToDate(datePickerAlta2));
	    p2.setFechaNacimiento(Utilidades
		    .datePickerToDate(datePickerNacimiento2));
	    p2.setMail(fieldCorreo2.getText());
	    p2.setNombre(fieldNombre2.getText());
	    p2.setOcupacion(fieldOcupación2.getText());
	    p2.setTelefono(fieldTelefono2.getText());

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

}