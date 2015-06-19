package com.mutual.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import com.mutual.modelo.Sistema;
import com.mutual.principal.Principal;
import com.mutual.reporte.AbstractJasperReports;
import com.mutual.util.Utilidades;

public class ControladorFechasInicioFin {

    @FXML
    private Button buttonBuscar;

    @FXML
    private DatePicker datePickerFin;

    @FXML
    private Button buttonCancelar;

    @FXML
    private DatePicker datePickerInicio;

    private Principal principal;

    private Stage escenario;

    public Button getButtonBuscar() {
	return buttonBuscar;
    }

    public DatePicker getDatePickerFin() {
	return datePickerFin;
    }

    public Button getButtonCancelar() {
	return buttonCancelar;
    }

    public DatePicker getDatePickerInicio() {
	return datePickerInicio;
    }

    public Principal getPrincipal() {
	return principal;
    }

    public Stage getEscenario() {
	return escenario;
    }

    public void setButtonBuscar(Button buttonBuscar) {
	this.buttonBuscar = buttonBuscar;
    }

    public void setDatePickerFin(DatePicker datePickerFin) {
	this.datePickerFin = datePickerFin;
    }

    public void setButtonCancelar(Button buttonCancelar) {
	this.buttonCancelar = buttonCancelar;
    }

    public void setDatePickerInicio(DatePicker datePickerInicio) {
	this.datePickerInicio = datePickerInicio;
    }

    public void setPrincipal(Principal principal) {
	this.principal = principal;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

    @FXML
    void buscar(ActionEvent event) {
	Map<String, Object> parametros = new HashMap<String, Object>();
	Date fechaInicio = Utilidades.datePickerToDate(datePickerInicio);
	Date fechaFin = Utilidades.datePickerToDate(datePickerFin);
	parametros.put("FECHA_INICIO", fechaInicio);
	parametros.put("FECHA_FIN", fechaFin);
	String path = "Ticket.jasper";
	Sistema.getSistema().cargarReporte(path, parametros);
	AbstractJasperReports.showViewer("Control de Ventas");

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

}