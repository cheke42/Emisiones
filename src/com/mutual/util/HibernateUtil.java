package com.mutual.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mutual.modelo.Itinerario;
import com.mutual.modelo.Persona;
import com.mutual.modelo.Sistema;
import com.mutual.modelo.Ticket;
import com.mutual.modelo.Usuario;

@SuppressWarnings({ "deprecation", "unused" })
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
	try {
	    AnnotationConfiguration config = new AnnotationConfiguration();
	    config.addAnnotatedClass(Itinerario.class);
	    config.addAnnotatedClass(Persona.class);
	    config.addAnnotatedClass(Ticket.class);
	    config.addAnnotatedClass(Usuario.class);
	    config.configure("hibernate.cfg.xml");
	    return config.buildSessionFactory();
	} catch (Throwable ex) {
	    System.err.println("Error en la creaccion de SessionFactory." + ex);
	    throw new ExceptionInInitializerError(ex);
	}
    }

    public static SessionFactory getSessionFactory() {

	return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public static List<Usuario> obtenerListaUsuarios() {
	List<Usuario> usuarios = new ArrayList<Usuario>();
	Transaction trns = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    trns = session.beginTransaction();
	    usuarios = session.createQuery("FROM Usuario").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return usuarios;
    }

    @SuppressWarnings("unchecked")
    public static List<Itinerario> obtenerListaItinerarios() {
	List<Itinerario> itinerarios = new ArrayList<Itinerario>();
	Transaction trns = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    trns = session.beginTransaction();
	    itinerarios = session.createQuery("FROM Itinerario").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return itinerarios;
    }

    @SuppressWarnings("unchecked")
    public static List<Ticket> obtenerListaTickets() {
	List<Ticket> tickets = new ArrayList<Ticket>();
	Transaction trns = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    trns = session.beginTransaction();
	    tickets = session.createQuery("FROM Ticket").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return tickets;
    }

    @SuppressWarnings("unchecked")
    public static List<Persona> obtenerListaPersonas() {
	List<Persona> personas = new ArrayList<Persona>();
	Transaction trns = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    trns = session.beginTransaction();
	    personas = session.createQuery("FROM Persona").list();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    session.flush();
	    session.close();
	}
	return personas;
    }

    public static void traerPersonasBase() {
	Sistema.getSistema().setPersonas(null);
	Sistema.getSistema().setPersonas(obtenerListaPersonas());
    }

    public static void traerTicketBase() {
	Sistema.getSistema().setTickets(null);
	Sistema.getSistema().setTickets(obtenerListaTickets());
    }

    public static void traerDatosBase() {
	Sistema.getSistema().setItinerarios(null);
	Sistema.getSistema().setPersonas(null);
	Sistema.getSistema().setTickets(null);
	Sistema.getSistema().setUsuarios(null);
	Sistema.getSistema().setUsuarios(obtenerListaUsuarios());
	Sistema.getSistema().setItinerarios(obtenerListaItinerarios());
	Sistema.getSistema().setPersonas(obtenerListaPersonas());
	Sistema.getSistema().setTickets(obtenerListaTickets());
    }

}