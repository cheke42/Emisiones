package com.mutual.modelo;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.hibernate.Session;

import com.mutual.property.TicketProperty;
import com.mutual.reporte.AbstractJasperReports;
import com.mutual.reporte.ConnectionDB;
import com.mutual.util.HibernateUtil;
import com.mutual.util.Utilidades;

public class Sistema {
    private static Sistema sistema = new Sistema();

    // private String nombre = "SGA  -  Sistema de Gestion de Acuarios";
    // private Image favicon = new Image("file:recursos/imagenes/favicon.png");
    private static ConnectionDB con;
    private List<Itinerario> itinerarios;
    private List<Persona> personas;
    private List<Ticket> tickets;
    private List<Usuario> usuarios;
    private ObservableList<TicketProperty> listaTickets = FXCollections
	    .observableArrayList();

    private Sistema() {
	itinerarios = new ArrayList<Itinerario>();
	personas = new ArrayList<Persona>();
	tickets = new ArrayList<Ticket>();
	usuarios = new ArrayList<Usuario>();
    }

    private static void conectToDatabase() {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String db = "acuariobd";

	con = new ConnectionDB(driver, db, url);
	con.connect();

    }

    public static Sistema getSistema() {

	return sistema;

    }

    public void cargarReporte(String reporte) {
	conectToDatabase();
	AbstractJasperReports.createReport(con.getConn(), reporte);
    }

    // private static ConnectionDB getCon() {
    // return con;
    // }

    public static void setCon(ConnectionDB con) {
	Sistema.con = con;
    }

    public ObservableList<TicketProperty> getListaTickets() {
	return listaTickets;
    }

    public void setListaTickets(ObservableList<TicketProperty> listaTickets) {
	this.listaTickets = listaTickets;
    }

    public List<Itinerario> getItinerarios() {
	return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
	this.itinerarios = itinerarios;
    }

    public List<Persona> getPersonas() {
	return personas;
    }

    public void setPersonas(List<Persona> personas) {
	this.personas = personas;
    }

    public List<Ticket> getTickets() {
	return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
	this.tickets = tickets;
    }

    public List<Usuario> getUsuarios() {
	return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
    }

    public Usuario buscarUsuario(String usuario) {
	Usuario utmp = null;

	for (int i = 0; i < this.usuarios.size(); i++) {
	    if (this.usuarios.get(i).getUsuario().equals(usuario)) {
		utmp = this.usuarios.get(i);
	    }
	}
	return utmp;

    }

    public Boolean loginCorrecto(String nombre, String password) {
	Boolean btmp = false;
	Usuario tusuario = buscarUsuario(nombre);
	if (tusuario != null) {
	    if (tusuario.getPassword().equals(password)) {
		btmp = true;
	    }
	}
	return btmp;

    }

    public ArrayList<String> listaDniPasajeros() {
	ArrayList<String> lista = new ArrayList<String>();
	if (personas.size() > 0) {
	    for (int i = 0; i < personas.size(); i++) {
		lista.add(Integer.toString(personas.get(i).getDni()));
	    }
	}
	return lista;
    }

    public Persona buscarPersona(int dni) {
	Persona persona = null;
	if (personas.size() > 0) {
	    for (int i = 0; i < personas.size(); i++) {
		if (personas.get(i).getDni() == dni) {
		    persona = personas.get(i);
		}
	    }
	}
	return persona;

    }

    public boolean existePersona(int dni) {
	boolean existe = false;
	if (personas.size() > 0) {
	    for (int i = 0; i < personas.size(); i++) {
		if (personas.get(i).getDni() == dni) {
		    existe = true;
		}
	    }
	}

	return existe;
    }

    public Itinerario buscarItinerario(String codigoAeropuerto) {
	System.out.println("Entró a buscarPersona con -" + codigoAeropuerto
		+ "-");
	Itinerario iti = null;
	for (Itinerario itinerario : itinerarios) {
	    if (itinerario.getCodigoAeropuerto().equals(codigoAeropuerto)) {
		System.out.println("encontró itinerario: "
			+ codigoAeropuerto.toUpperCase());
		iti = itinerario;
	    }
	}
	return iti;
    }

    public void ActualizarlistaTicketProperty() {
	HibernateUtil.traerTicketBase();
	listaTickets.clear();

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	try {
	    session.beginTransaction();
	    for (Ticket ticket : this.tickets) {
		Ticket ticketHiber = (Ticket) session.get(Ticket.class,
			ticket.getNumero());
		String itinerario = "";
		if (ticket.isIdaVuelta()) {
		    for (Itinerario itH : ticketHiber.getItinerarios()) {
			itinerario = itinerario + itH.getCodigoAeropuerto()
				+ " ";
		    }

		    for (int i = ticketHiber.getItinerarios().size() - 2; i >= 0; i--) {
			itinerario = itinerario
				+ ticketHiber.getItinerarios().get(i)
					.getCodigoAeropuerto() + " ";
		    }

		} else {
		    for (Itinerario itH : ticketHiber.getItinerarios()) {
			itinerario = itinerario + itH.getCodigoAeropuerto()
				+ " ";
		    }
		}

		this.listaTickets.add(new TicketProperty(ticketHiber
			.getPasajero().getDni(), ticketHiber.getPasajero()
			.getApellido().toUpperCase()
			+ " " + ticketHiber.getPasajero().getNombre(),
			itinerario, Utilidades.fechaFormateada(ticketHiber
				.getFechaEmision()), Utilidades
				.fechaFormateada(ticketHiber.getFechaViaje()),
			ticketHiber.getSolicitante().getApellido()
				.toUpperCase()
				+ " "
				+ ticketHiber.getSolicitante().getNombre(),
			ticketHiber.getNumero(), ""));
	    }
	    session.getTransaction().commit();
	} catch (Exception e) {
	    session.getTransaction().rollback();
	    throw e;
	}

    }

    public boolean existeTicket(Long numeroTicket) {
	boolean existe = false;
	for (Ticket ticket : tickets) {
	    if (ticket.getNumero() == numeroTicket) {
		existe = true;
		break;
	    }
	}
	return existe;
    }

}
