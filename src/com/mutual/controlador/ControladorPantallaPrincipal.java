package com.mutual.controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import com.mutual.enumerado.TipoVentana;
import com.mutual.modelo.Sistema;
import com.mutual.principal.Principal;
import com.mutual.property.TicketProperty;

public class ControladorPantallaPrincipal {
    @FXML
    private TableView<TicketProperty> tabla;

    @FXML
    private Button buttonAgregarPersona;

    @FXML
    private ImageView imageAgregarFactura;

    @FXML
    private ImageView imageAgregarPersona;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Button buttonAgregarFactura;

    @FXML
    private Button buttonAeropuertoArgentino;

    @FXML
    private ImageView imageAeropuertoArgentino;

    @FXML
    private ImageView imageAgregarTicket;

    @FXML
    private Button buttonAgregarTicket;

    @FXML
    private TableColumn<TicketProperty, String> tableColumnPasajero;

    @FXML
    private TableColumn<TicketProperty, String> tableColumnFechaViaje;

    @FXML
    private TableColumn<TicketProperty, String> tableColumnFechaEmision;

    @FXML
    private TableColumn<TicketProperty, String> tableColumnEstado;

    @FXML
    private TableColumn<TicketProperty, Number> TableColumnTicket;

    public ImageView getImageAgregarFactura() {
	return imageAgregarFactura;
    }

    public void setImageAgregarFactura(ImageView imageAgregarFactura) {
	this.imageAgregarFactura = imageAgregarFactura;
    }

    @FXML
    private TableColumn<TicketProperty, String> tableColumnItinerario;

    @FXML
    private TableColumn<TicketProperty, Number> tableColumnDni;

    @FXML
    private TableColumn<TicketProperty, String> tableColumnSolicitante;

    private Principal principal;

    private Stage escenario;

    public Stage getEscenario() {
	return escenario;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

    public Button getButtonAgregarPersona() {
	return buttonAgregarPersona;
    }

    public ImageView getImageAgregarPersona() {
	return imageAgregarPersona;
    }

    public void setButtonAgregarPersona(Button buttonAgregarPersona) {
	this.buttonAgregarPersona = buttonAgregarPersona;
    }

    public void setImageAgregarPersona(ImageView imageAgregarPersona) {
	this.imageAgregarPersona = imageAgregarPersona;
    }

    public TableColumn<TicketProperty, Number> getTableColumnTicket() {
	return TableColumnTicket;
    }

    public void setTableColumnTicket(
	    TableColumn<TicketProperty, Number> tableColumnTicket) {
	TableColumnTicket = tableColumnTicket;
    }

    public TableColumn<TicketProperty, Number> getTableColumnDni() {
	return tableColumnDni;
    }

    public void setTableColumnDni(
	    TableColumn<TicketProperty, Number> tableColumnDni) {
	this.tableColumnDni = tableColumnDni;
    }

    public Button getButtonAgregarFactura() {
	return buttonAgregarFactura;
    }

    public void setButtonAgregarFactura(Button buttonAgregarFactura) {
	this.buttonAgregarFactura = buttonAgregarFactura;
    }

    public TableView<TicketProperty> getTabla() {
	return tabla;
    }

    public TableColumn<TicketProperty, String> getTableColumnPasajero() {
	return tableColumnPasajero;
    }

    public TableColumn<TicketProperty, String> getTableColumnEstado() {
	return tableColumnEstado;
    }

    public TableColumn<TicketProperty, String> getTableColumnItinerario() {
	return tableColumnItinerario;
    }

    public TableColumn<TicketProperty, String> getTableColumnSolicitante() {
	return tableColumnSolicitante;
    }

    public void setTabla(TableView<TicketProperty> tabla) {
	this.tabla = tabla;
    }

    public void setTableColumnPasajero(
	    TableColumn<TicketProperty, String> tableColumnPasajero) {
	this.tableColumnPasajero = tableColumnPasajero;
    }

    public void setTableColumnEstado(
	    TableColumn<TicketProperty, String> tableColumnEstado) {
	this.tableColumnEstado = tableColumnEstado;
    }

    public void setTableColumnItinerario(
	    TableColumn<TicketProperty, String> tableColumnItinerario) {
	this.tableColumnItinerario = tableColumnItinerario;
    }

    public void setTableColumnSolicitante(
	    TableColumn<TicketProperty, String> tableColumnSolicitante) {
	this.tableColumnSolicitante = tableColumnSolicitante;
    }

    public ToolBar getToolBar() {
	return toolBar;
    }

    public void setToolBar(ToolBar toolBar) {
	this.toolBar = toolBar;
    }

    public Button getButtonAeropuertoArgentino() {
	return buttonAeropuertoArgentino;
    }

    public void setButtonAeropuertoArgentino(Button buttonAeropuertoArgentino) {
	this.buttonAeropuertoArgentino = buttonAeropuertoArgentino;
    }

    public ImageView getImageAeropuertoArgentino() {
	return imageAeropuertoArgentino;
    }

    public void setImageAeropuertoArgentino(ImageView imageAeropuertoArgentino) {
	this.imageAeropuertoArgentino = imageAeropuertoArgentino;
    }

    public Principal getPrincipal() {
	return principal;
    }

    public void setPrincipal(Principal principal) {
	tabla.setItems(Sistema.getSistema().getListaTickets());
	this.principal = principal;
    }

    public ImageView getImageAgregarTicket() {
	return imageAgregarTicket;
    }

    public void setImageAgregarTicket(ImageView imageAgregarTicket) {
	this.imageAgregarTicket = imageAgregarTicket;
    }

    public Button getButtonAgregarTicket() {
	return buttonAgregarTicket;
    }

    public void setButtonAgregarTicket(Button buttonAgregarTicket) {
	this.buttonAgregarTicket = buttonAgregarTicket;
    }

    public TableColumn<TicketProperty, String> getTableColumnFechaViaje() {
	return tableColumnFechaViaje;
    }

    public TableColumn<TicketProperty, String> getTableColumnFechaEmision() {
	return tableColumnFechaEmision;
    }

    public void setTableColumnFechaViaje(
	    TableColumn<TicketProperty, String> tableColumnFechaViaje) {
	this.tableColumnFechaViaje = tableColumnFechaViaje;
    }

    public void setTableColumnFechaEmision(
	    TableColumn<TicketProperty, String> tableColumnFechaEmision) {
	this.tableColumnFechaEmision = tableColumnFechaEmision;
    }

    @FXML
    private void initialize() {

	tabla.setRowFactory(tv -> {
	    TableRow<TicketProperty> row = new TableRow<>();
	    row.setOnMouseClicked(event -> {
		if (event.getClickCount() == 2 && (!row.isEmpty())) {

		    try {
			principal.cargarVentanaTicket(TipoVentana.UPDATE,
				tabla, row.getItem().getTicket());
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    });
	    return row;
	});

	tableColumnDni.setCellValueFactory(cellData -> cellData.getValue()
		.DniProperty());
	tableColumnEstado.setCellValueFactory(cellData -> cellData.getValue()
		.estadoProperty());
	tableColumnFechaEmision.setCellValueFactory(cellData -> cellData
		.getValue().FechaEmisionProperty());
	tableColumnFechaViaje.setCellValueFactory(cellData -> cellData
		.getValue().FechaViajeProperty());
	tableColumnItinerario.setCellValueFactory(cellData -> cellData
		.getValue().ItinerarioProperty());
	tableColumnPasajero.setCellValueFactory(cellData -> cellData.getValue()
		.pasajeroProperty());
	tableColumnSolicitante.setCellValueFactory(cellData -> cellData
		.getValue().SolicitanteProperty());
	TableColumnTicket.setCellValueFactory(cellData -> cellData.getValue()
		.ticketProperty());
	tableColumnDni.setStyle("-fx-alignment: CENTER;");

	tableColumnDni.setCellValueFactory(cellData -> cellData.getValue()
		.DniProperty());
	tableColumnEstado.setStyle("-fx-alignment: CENTER;");
	tableColumnFechaEmision.setStyle("-fx-alignment: CENTER;");
	tableColumnFechaViaje.setStyle("-fx-alignment: CENTER;");
	tableColumnItinerario.setStyle("-fx-alignment: CENTER;");
	TableColumnTicket.setStyle("-fx-alignment: CENTER;");

    }

    @FXML
    void salir() {
	escenario.close();
    }

    @FXML
    void aeropuertosArgentina(ActionEvent event) {
	try {
	    principal.cargarVentanaAeropuertoArgentina();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    System.err.println(e);
	}
    }

    @FXML
    void agregarTicket(ActionEvent event) throws Exception {
	principal.cargarVentanaTicket(TipoVentana.NUEVA, tabla, 0);
    }

    @FXML
    void agregarPersona() throws Exception {
	principal.cargarVentanaSocio(TipoVentana.NUEVA, null);
    }

    @FXML
    void cerrarSesion() throws Exception {
	principal.setUsuarioActivo(null);
	principal.cargarVentanaLogin();
    }

    @FXML
    void buscarPersona() throws Exception {
	principal.cargarVentanaSocio(TipoVentana.BUSCAR, null);
    }

    @FXML
    void buscarSocio(){
	principal.buscarPersona();
    }
    
}
