package com.mutual.controlador;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.DialogStyle;
import org.controlsfx.dialog.Dialogs;
import org.hibernate.Session;

import com.mutual.componentes.AutoCompleteTextField;
import com.mutual.enumerado.TipoVentana;
import com.mutual.modelo.Itinerario;
import com.mutual.modelo.Persona;
import com.mutual.modelo.Sistema;
import com.mutual.modelo.Ticket;
import com.mutual.modelo.Usuario;
import com.mutual.principal.Principal;
import com.mutual.property.TicketProperty;
import com.mutual.util.CodigoAeropuerto;
import com.mutual.util.HibernateUtil;
import com.mutual.util.Utilidades;

public class ControladorTicket {

    @FXML
    private TableView<TicketProperty> tabla;

    @FXML
    private TextField fieldImpuestos;

    @FXML
    private ListView<String> listViewItinerario;

    @FXML
    private GridPane gridItinerarioOrigen;

    @FXML
    private DatePicker datePickerEmision;

    @FXML
    private GridPane gridDniSolicitante;

    @FXML
    private TextField fieldApellidoPasajero;

    @FXML
    private TextField fieldNombreSolicitante;

    @FXML
    private CheckBox checkBoxIdaVuelta;

    @FXML
    private TextField fieldEmisor;

    @FXML
    private GridPane gridItinerarioDestino;

    @FXML
    private Button buttonCancelar;

    @FXML
    private TextField fieldTarifaBase;

    @FXML
    private Button buttonGuardar;

    @FXML
    private GridPane gridDniPasajero;

    @FXML
    private DatePicker datePickerVuelo;

    @FXML
    private TextField fieldNombrePasajero;

    @FXML
    private TextField fieldNumeroTicket;

    @FXML
    private TextField fieldApellidoSolicitante;

    @FXML
    private ImageView imageError;

    @FXML
    private Label labelError;

    private TipoVentana tipoVentana;

    private Principal principal;

    private Stage escenario;

    private AutoCompleteTextField ACFieldDniPasajero;

    private AutoCompleteTextField ACFieldItinerarioOrigen;

    private AutoCompleteTextField ACFieldItinerarioDestino;

    private AutoCompleteTextField ACFieldDniSolicitante;

    public Label getLabelError() {
	return labelError;
    }

    public void setLabelError(Label labelError) {
	this.labelError = labelError;
    }

    public ImageView getImageError() {
	return imageError;
    }

    public TableView<TicketProperty> getTabla() {
	return tabla;
    }

    public void setTabla(TableView<TicketProperty> tabla) {
	this.tabla = tabla;
    }

    public ListView<String> getListViewItinerario() {
	return listViewItinerario;
    }

    public void setListViewItinerario(ListView<String> listViewItinerario) {
	this.listViewItinerario = listViewItinerario;
    }

    public void setImageError(ImageView imageError) {
	this.imageError = imageError;
    }

    public TextField getFieldApellidoSolicitante() {
	return fieldApellidoSolicitante;
    }

    public void setFieldApellidoSolicitante(TextField fieldApellidoSolicitante) {
	this.fieldApellidoSolicitante = fieldApellidoSolicitante;
    }

    public TextField getFieldApellidoPasajero() {
	return fieldApellidoPasajero;
    }

    public void setFieldApellidoPasajero(TextField fieldApellidoPasajero) {
	this.fieldApellidoPasajero = fieldApellidoPasajero;
    }

    public Stage getEscenario() {
	return escenario;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

    public Principal getPrincipal() {
	return principal;
    }

    public void setPrincipal(Principal principal) {
	this.principal = principal;
    }

    public AutoCompleteTextField getACFieldDniPasajero() {
	return ACFieldDniPasajero;
    }

    public void setACFieldDniPasajero(AutoCompleteTextField aCFieldDniPasajero) {
	ACFieldDniPasajero = aCFieldDniPasajero;
    }

    public AutoCompleteTextField getACFieldItinerarioOrigen() {
	return ACFieldItinerarioOrigen;
    }

    public void setACFieldItinerarioOrigen(
	    AutoCompleteTextField aCFieldItinerarioOrigen) {
	ACFieldItinerarioOrigen = aCFieldItinerarioOrigen;
    }

    public AutoCompleteTextField getACFieldItinerarioDestino() {
	return ACFieldItinerarioDestino;
    }

    public void setACFieldItinerarioDestino(
	    AutoCompleteTextField aCFieldItinerarioDestino) {
	ACFieldItinerarioDestino = aCFieldItinerarioDestino;
    }

    public AutoCompleteTextField getACFieldDniSolicitante() {
	return ACFieldDniSolicitante;
    }

    public void setACFieldDniSolicitante(
	    AutoCompleteTextField aCFieldDniSolicitante) {
	ACFieldDniSolicitante = aCFieldDniSolicitante;
    }

    public TipoVentana getTipoVentana() {
	return tipoVentana;
    }

    public void setTipoVentana(TipoVentana tipoVentana) {
	this.tipoVentana = tipoVentana;
    }

    public TextField getFieldNumeroTicket() {
	return fieldNumeroTicket;
    }

    public void setFieldNumeroTicket(TextField fieldNumeroTicket) {
	this.fieldNumeroTicket = fieldNumeroTicket;
    }

    public TextField getFieldImpuestos() {
	return fieldImpuestos;
    }

    public void setFieldImpuestos(TextField fieldImpuestos) {
	this.fieldImpuestos = fieldImpuestos;
    }

    public GridPane getGridItinerarioOrigen() {
	return gridItinerarioOrigen;
    }

    public void setGridItinerarioOrigen(GridPane gridItinerarioOrigen) {
	this.gridItinerarioOrigen = gridItinerarioOrigen;
    }

    public DatePicker getDatePickerEmision() {
	return datePickerEmision;
    }

    public void setDatePickerEmision(DatePicker datePickerEmision) {
	this.datePickerEmision = datePickerEmision;
    }

    public GridPane getGridDniSolicitante() {
	return gridDniSolicitante;
    }

    public void setGridDniSolicitante(GridPane gridDniSolicitante) {
	this.gridDniSolicitante = gridDniSolicitante;
    }

    public TextField getFieldNombreSolicitante() {
	return fieldNombreSolicitante;
    }

    public void setFieldNombreSolicitante(TextField fieldNombreSolicitante) {
	this.fieldNombreSolicitante = fieldNombreSolicitante;
    }

    public CheckBox getCheckBoxIdaVuelta() {
	return checkBoxIdaVuelta;
    }

    public void setCheckBoxIdaVuelta(CheckBox checkBoxIdaVuelta) {
	this.checkBoxIdaVuelta = checkBoxIdaVuelta;
    }

    public TextField getFieldEmisor() {
	return fieldEmisor;
    }

    public void setFieldEmisor(TextField fieldEmisor) {
	this.fieldEmisor = fieldEmisor;
    }

    public GridPane getGridItinerarioDestino() {
	return gridItinerarioDestino;
    }

    public void setGridItinerarioDestino(GridPane gridItinerarioDestino) {
	this.gridItinerarioDestino = gridItinerarioDestino;
    }

    public Button getButtonCancelar() {
	return buttonCancelar;
    }

    public void setButtonCancelar(Button buttonCancelar) {
	this.buttonCancelar = buttonCancelar;
    }

    public TextField getFieldTarifaBase() {
	return fieldTarifaBase;
    }

    public void setFieldTarifaBase(TextField fieldTarifaBase) {
	this.fieldTarifaBase = fieldTarifaBase;
    }

    public Button getButtonGuardar() {
	return buttonGuardar;
    }

    public void setButtonGuardar(Button buttonGuardar) {
	this.buttonGuardar = buttonGuardar;
    }

    public GridPane getGridDniPasajero() {
	return gridDniPasajero;
    }

    public void setGridDniPasajero(GridPane gridDniPasajero) {
	this.gridDniPasajero = gridDniPasajero;
    }

    public DatePicker getDatePickerVuelo() {
	return datePickerVuelo;
    }

    public void setDatePickerVuelo(DatePicker datePickerVuelo) {
	this.datePickerVuelo = datePickerVuelo;
    }

    public TextField getFieldNombrePasajero() {
	return fieldNombrePasajero;
    }

    public void setFieldNombrePasajero(TextField fieldNombrePasajero) {
	this.fieldNombrePasajero = fieldNombrePasajero;
    }

    @FXML
    private void initialize() {
	final ContextMenu contextMenu = new ContextMenu();
	MenuItem cut = new MenuItem("Borrar");
	contextMenu.getItems().add(cut);
	cut.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		System.out.println(item.toString());
		System.out.println(item.getText());
		System.out.println(event.toString());
		System.out.println("Dió a borrar");
	    }
	});

	listViewItinerario.setContextMenu(contextMenu);

	ACFieldItinerarioOrigen = new AutoCompleteTextField() {
	    @Override
	    public void replaceText(int start, int end, String text) {

		if (!text.matches("[0-9]") & !text.matches("\\s")) {
		    super.replaceText(start, end, text.toUpperCase());
		}
	    }
	};

	ACFieldItinerarioDestino = new AutoCompleteTextField() {
	    @Override
	    public void replaceText(int start, int end, String text) {
		if (!text.matches("[0-9]") & !text.matches("\\s")) {
		    super.replaceText(start, end, text.toUpperCase());
		}
	    }
	};

	ACFieldDniPasajero = new AutoCompleteTextField() {
	    @Override
	    public void replaceText(int start, int end, String text) {
		if (!text.matches("[a-zA-Z]+") && !text.matches("\\s")) {
		    if ((ACFieldDniPasajero.getText().length() < 8)
			    && (!Utilidades.esSimbolo(text))) {
			super.replaceText(start, end, text.toUpperCase());
		    } else {
			super.replaceText(start, end, "");
		    }
		}
	    }
	};
	ACFieldDniSolicitante = new AutoCompleteTextField() {
	    @Override
	    public void replaceText(int start, int end, String text) {
		if (!text.matches("[a-zA-Z]+") && !text.matches("\\s")) {
		    if ((ACFieldDniSolicitante.getText().length() < 8)
			    && (!Utilidades.esSimbolo(text))) {
			super.replaceText(start, end, text.toUpperCase());
		    } else {
			super.replaceText(start, end, "");
		    }
		}
	    }
	};

	ACFieldItinerarioOrigen.getEntries().addAll(
		CodigoAeropuerto.codigoAeropuerto);
	ACFieldItinerarioDestino.getEntries().addAll(
		CodigoAeropuerto.codigoAeropuerto);
	ACFieldDniPasajero.getEntries().addAll(
		Sistema.getSistema().listaDniPasajeros());
	ACFieldDniSolicitante.getEntries().addAll(
		Sistema.getSistema().listaDniPasajeros());

	ACFieldDniPasajero.addEventHandler(ActionEvent.ACTION,
		new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
			int dniPasajero = Integer.parseInt(ACFieldDniPasajero
				.getText());
			if (event.getEventType().equals(ActionEvent.ACTION)) {
			    fieldApellidoPasajero.clear();
			    fieldNombrePasajero.clear();
			    if (!Sistema.getSistema()
				    .existePersona(dniPasajero)) {
				fieldApellidoPasajero.requestFocus();
				fieldApellidoPasajero.setEditable(true);
				fieldNombrePasajero.setEditable(true);
			    } else {
				fieldApellidoPasajero.setText(Sistema
					.getSistema()
					.buscarPersona(dniPasajero)
					.getApellido());
				fieldNombrePasajero
					.setText(Sistema.getSistema()
						.buscarPersona(dniPasajero)
						.getNombre());
				fieldApellidoPasajero.setEditable(false);
				fieldNombrePasajero.setEditable(false);
				ACFieldItinerarioOrigen.requestFocus();
			    }
			}
		    }
		});
	ACFieldDniSolicitante.addEventHandler(ActionEvent.ACTION,
		new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
			int dniSolicitante = Integer
				.parseInt(ACFieldDniSolicitante.getText());
			if (event.getEventType().equals(ActionEvent.ACTION)) {
			    fieldNombreSolicitante.clear();
			    fieldApellidoSolicitante.clear();
			    if (!Sistema.getSistema().existePersona(
				    dniSolicitante)) {
				fieldNombreSolicitante.requestFocus();
				fieldApellidoSolicitante.setEditable(true);
				fieldNombreSolicitante.setEditable(true);
			    } else {
				fieldNombreSolicitante.setText(Sistema
					.getSistema()
					.buscarPersona(dniSolicitante)
					.getNombre());
				fieldApellidoSolicitante.setText(Sistema
					.getSistema()
					.buscarPersona(dniSolicitante)
					.getApellido());
				fieldApellidoSolicitante.setEditable(false);
				fieldNombreSolicitante.setEditable(false);
				fieldNumeroTicket.requestFocus();
			    }
			}
		    }
		});

	ACFieldItinerarioOrigen.addEventHandler(ActionEvent.ACTION,
		new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
			if (event.getEventType().equals(ActionEvent.ACTION)) {

			    ACFieldItinerarioOrigen
				    .setText(ACFieldItinerarioOrigen.getText());
			    listViewItinerario.getItems().add(
				    ACFieldItinerarioOrigen.getText());
			    ACFieldItinerarioOrigen.setText("");
			    ACFieldItinerarioOrigen.requestFocus();
			}
		    }
		});

	ACFieldItinerarioDestino.addEventHandler(ActionEvent.ACTION,
		new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
			ACFieldItinerarioDestino
				.setText(ACFieldItinerarioDestino.getText()
					.substring(0, 3));
			checkBoxIdaVuelta.requestFocus();
		    }
		});

	ACFieldItinerarioDestino.setPromptText("Destino");
	ACFieldItinerarioOrigen.setPromptText("Origen");
	ACFieldDniPasajero.setPromptText("DNI del pasajero");
	ACFieldDniSolicitante.setPromptText("DNI del solicitante");
	gridDniPasajero.add(ACFieldDniPasajero, 0, 0);
	gridDniSolicitante.add(ACFieldDniSolicitante, 0, 0);
	gridItinerarioDestino.add(ACFieldItinerarioDestino, 0, 0);
	gridItinerarioOrigen.add(ACFieldItinerarioOrigen, 0, 0);

    }

    @FXML
    void fieldNombrePasajeroSeleccionado(ActionEvent event) {
	System.out.println("ASA");
    }

    @FXML
    void cancelar(ActionEvent event) {
	salir();
    }

    @FXML
    void guardar(ActionEvent event) throws Exception {
	ArrayList<Integer> usuariosNuevos = new ArrayList<Integer>();
	if (tipoVentana == TipoVentana.NUEVA) {

	    if (ventanaValida()) {
		usuariosNuevos = nuevasPersonas(usuariosNuevos);
		guardarNuevoTicket();
		Sistema.getSistema().ActualizarlistaTicketProperty();
		salir();
		if (usuariosNuevos.size() > 0) {
		    Action response = Dialogs
			    .create()
			    .style(DialogStyle.NATIVE)
			    .title("Datos nuevos")
			    .message(
				    "Ha ingresado una persona nueva en el sistema, desea cargar el resto de sus datos?")
			    .showConfirm();

		    if (response == Dialog.Actions.YES) {
			salir();
			principal.cargarVentanaSocio(TipoVentana.UPDATE,
				usuariosNuevos);
		    } else if (response == Dialog.Actions.NO) {
			salir();
		    }
		}

	    }

	} else if (tipoVentana == TipoVentana.UPDATE) {
	    System.out.println("Update");
	    Session session = HibernateUtil.getSessionFactory()
		    .getCurrentSession();
	    // try {
	    session.beginTransaction();
	    Ticket ticket = (Ticket) session.get(Ticket.class,
		    Long.parseLong(fieldNumeroTicket.getText()));
	    System.out.println(ticket.getPasajero().getDni());
	    ticket.getItinerarios().clear();

	    Itinerario itDestino = (Itinerario) session
		    .get(Itinerario.class,
			    Sistema.getSistema()
				    .buscarItinerario(
					    ACFieldItinerarioOrigen.getText())
				    .getIdItinerario());
	    Itinerario itOrigen = (Itinerario) session.get(
		    Itinerario.class,
		    Sistema.getSistema()
			    .buscarItinerario(
				    ACFieldItinerarioDestino.getText())
			    .getIdItinerario());
	    ticket.setItinerarios(new ArrayList<Itinerario>(Arrays.asList(
		    itOrigen, itDestino)));
	    ticket.setIdaVuelta(checkBoxIdaVuelta.isSelected());
	    ticket.setFechaEmision(Utilidades
		    .datePickerToDate(datePickerEmision));
	    ticket.setFechaViaje(Utilidades.datePickerToDate(datePickerVuelo));
	    ticket.setTarifaBase(Float.parseFloat(fieldTarifaBase.getText()));
	    ticket.setImpuesto(Float.parseFloat(fieldImpuestos.getText()));
	    session.update(ticket);
	    session.getTransaction().commit();
	    HibernateUtil.traerTicketBase();
	    Sistema.getSistema().ActualizarlistaTicketProperty();
	    salir();

	    // } catch (Exception e) {
	    // System.out.println("entró al error");
	    // if (session.getTransaction() == null) {
	    // session.getTransaction().rollback();
	    //
	    // }
	    // }
	}
    }

    private boolean ventanaValida() {
	boolean valida = true;
	imageError.setVisible(false);
	labelError.setVisible(false);

	if (componenteValido(ACFieldDniPasajero, valida)) {
	    valida = dibujarErrorNode(ACFieldDniPasajero, gridDniPasajero,
		    valida, "Se requiere un DNI");

	}

	if (componenteValido(fieldApellidoPasajero, valida)) {
	    valida = dibujarErrorNode(fieldApellidoPasajero, valida,
		    "Se requiere un apellido");
	}

	labelError.getText();

	if (componenteValido(fieldNombrePasajero, valida)) {
	    valida = dibujarErrorNode(fieldNombrePasajero, valida,
		    "Se requiere un nombre");
	}

	if (componenteValido(datePickerEmision.getEditor(), valida)) {
	    valida = dibujarErrorNode(datePickerEmision, valida,
		    "Fecha de emisión requerida");
	}

	if (componenteValido(datePickerVuelo.getEditor(), valida)) {
	    valida = dibujarErrorNode(datePickerVuelo, valida,
		    "Fecha de vuelo requerida");
	}
	if (componenteValido(ACFieldDniSolicitante, valida)) {
	    valida = dibujarErrorNode(ACFieldDniSolicitante,
		    gridDniSolicitante, valida, "Se requiere un DNI");
	}

	if (componenteValido(fieldApellidoSolicitante, valida)) {
	    valida = dibujarErrorNode(fieldApellidoSolicitante, valida,
		    "Se requiere un nombre");
	}

	if (componenteValido(fieldNombreSolicitante, valida)) {
	    valida = dibujarErrorNode(fieldNombreSolicitante, valida,
		    "Se requiere un nombre");
	}

	if (componenteValido(fieldNumeroTicket, valida)) {
	    valida = dibujarErrorNode(fieldNumeroTicket, valida,
		    "Se requiere numero de ticket");
	}

	if (componenteValido(fieldTarifaBase, valida)) {
	    valida = dibujarErrorNode(fieldTarifaBase, valida,
		    "Se requiere tarifa base");
	}

	if (componenteValido(fieldImpuestos, valida)) {
	    valida = dibujarErrorNode(fieldImpuestos, valida,
		    "Se requiere impuestos");
	}

	if (valida & !Utilidades.validarFlotante(fieldTarifaBase.getText())) {
	    valida = dibujarErrorNode(fieldTarifaBase, valida,
		    "Debe ser un numero");
	}

	if (valida & !Utilidades.validarFlotante(fieldImpuestos.getText())) {
	    valida = dibujarErrorNode(fieldImpuestos, valida,
		    "Debe ser un numero");
	}

	return valida;
    }

    private boolean componenteValido(TextInputControl textInputControl,
	    boolean valida) {

	return valida & textInputControl.getText().isEmpty();

    }

    private boolean dibujarErrorNode(Node node, boolean valida, String textError) {
	node.requestFocus();
	valida = false;
	imageError.setVisible(true);
	labelError.setVisible(true);
	imageError.setLayoutY(node.getLayoutY());
	imageError.setLayoutX(node.getLayoutX() + ((Region) node).getWidth()
		+ 2);
	labelError.setLayoutY(node.getLayoutY() + ((Region) node).getHeight());
	labelError.setLayoutX(node.getLayoutX());
	labelError.setText(textError);
	return valida;

    }

    private boolean dibujarErrorNode(Node autoField, Node grid, boolean valida,
	    String textError) {

	autoField.requestFocus();
	valida = false;
	imageError.setLayoutY(grid.getLayoutY() + 3);
	imageError.setLayoutX(grid.getLayoutX()
		+ ((Region) autoField).getWidth() + 2);
	labelError.setLayoutY(grid.getLayoutY()
		+ ((Region) autoField).getHeight() + 2);
	imageError.setVisible(true);
	labelError.setVisible(true);
	labelError.setLayoutX(grid.getLayoutX());
	labelError.setText(textError);
	return valida;
    }

    private void salir() {
	escenario.close();
    }

    /*
     * Devuelve un Array con personas nuevas ya persistidas. Si está vacio el
     * Array las personas ya existen
     */
    private ArrayList<Integer> nuevasPersonas(ArrayList<Integer> usuariosNuevos) {
	System.out.println("nuevasPersonas");
	int dniPasajero = Integer.parseInt(ACFieldDniPasajero.getText());
	int dniSolicitante = Integer.parseInt(ACFieldDniSolicitante.getText());
	if (!Sistema.getSistema().existePersona(dniPasajero)) {
	    guardarNuevaPersona(dniPasajero, fieldApellidoPasajero.getText(),
		    fieldNombrePasajero.getText());
	    usuariosNuevos.add(dniPasajero);
	}
	if (!Sistema.getSistema().existePersona(dniSolicitante)) {
	    guardarNuevaPersona(dniSolicitante,
		    fieldApellidoSolicitante.getText(),
		    fieldNombreSolicitante.getText());
	    usuariosNuevos.add(dniSolicitante);
	}

	return usuariosNuevos;
    }

    /*
     * Guarda nuevas personas en BD
     */
    private void guardarNuevaPersona(int dni, String apellido, String nombre) {
	System.out.println("guardarNuevaPersona");
	Persona nuevaPersona = new Persona();
	nuevaPersona.setDni(dni);
	nuevaPersona.setApellido(apellido);
	nuevaPersona.setNombre(nombre);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	try {
	    session.beginTransaction();
	    session.save(nuevaPersona);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    if (session.getTransaction() == null) {
		session.getTransaction().rollback();
		System.out
			.println("Entrón en excepcion de guardar nueva persona");
		throw e;
	    }
	}

    }

    private void guardarNuevoTicket() {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	try {
	    session.beginTransaction();
	    Ticket nuevoTicket = new Ticket();
	    ArrayList<Itinerario> tmpIt = new ArrayList<Itinerario>();
	    for (String itemList : listViewItinerario.getItems()) {
		tmpIt.add((Itinerario) session.get(Itinerario.class, Sistema
			.getSistema()
			.buscarItinerario(itemList.substring(0, 3))
			.getIdItinerario()));
	    }
	    nuevoTicket.setItinerarios(tmpIt);

	    Persona pasajero = (Persona) session.get(Persona.class,
		    Integer.parseInt(ACFieldDniPasajero.getText()));

	    Persona solicitante = (Persona) session.get(Persona.class,
		    Integer.parseInt(ACFieldDniSolicitante.getText()));

	    Usuario usuario = (Usuario) session.get(Usuario.class, principal
		    .getUsuarioActivo().getId());

	    nuevoTicket.setUsuario(usuario);
	    nuevoTicket.setSolicitante(solicitante);
	    nuevoTicket.setPasajero(pasajero);

	    nuevoTicket.setNumero(Long.parseLong(fieldNumeroTicket.getText(),
		    10));
	    nuevoTicket.setFechaEmision(Utilidades
		    .datePickerToDate(datePickerEmision));
	    nuevoTicket.setFechaViaje(Utilidades
		    .datePickerToDate(datePickerVuelo));
	    nuevoTicket.setIdaVuelta(checkBoxIdaVuelta.isSelected());
	    nuevoTicket.setImpuestosVarios(Float.parseFloat(fieldImpuestos
		    .getText()));
	    nuevoTicket.setTarifaBase(Float.parseFloat(fieldTarifaBase
		    .getText()));
	    nuevoTicket.setImpuesto(Float.parseFloat(fieldImpuestos.getText()));
	    nuevoTicket.calcularValoresFactura();

	    session.save(nuevoTicket);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    if (session.getTransaction() != null) {
		session.getTransaction().rollback();

		throw e;
	    }
	}

	HibernateUtil.traerPersonasBase();
    }
}