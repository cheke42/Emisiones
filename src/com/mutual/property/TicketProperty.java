package com.mutual.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Cheque
 *
 */
public class TicketProperty {
    private final IntegerProperty dni;
    private final StringProperty pasajero;
    private final StringProperty itinerario;
    private final LongProperty ticket;
    private StringProperty fechaEmision;
    private StringProperty fechaViaje;
    private final StringProperty solicitante;
    private final StringProperty estado;

    public TicketProperty(Integer dni, String pasajero, String itinerario,
	    String emision, String viaje, String solicitante, Long ticket,
	    String estado) {
	this.dni = new SimpleIntegerProperty(dni);
	this.pasajero = new SimpleStringProperty(pasajero);
	this.itinerario = new SimpleStringProperty(itinerario);
	this.fechaEmision = new SimpleStringProperty(emision);
	this.fechaViaje = new SimpleStringProperty(viaje);
	this.solicitante = new SimpleStringProperty(solicitante);
	this.ticket = new SimpleLongProperty(ticket);
	this.estado = new SimpleStringProperty(estado);
    }

    public IntegerProperty DniProperty() {
	return dni;
    }

    public StringProperty ItinerarioProperty() {
	return itinerario;
    }

    public StringProperty SolicitanteProperty() {
	return solicitante;
    }

    public Integer getDni() {
	return dni.get();
    }

    public String getItinerario() {
	return itinerario.get();
    }

    public String getSolicitante() {
	return solicitante.get();
    }

    public StringProperty getPasajero() {
	return pasajero;
    }

    public void setDni(Integer dni) {
	this.dni.set(dni);
    }

    public void setPasajero(String pasajero) {
	this.pasajero.set(pasajero);
    }

    public void setItinerario(String itinerario) {
	this.itinerario.set(itinerario);
    }

    public void setSolicitante(String solicitante) {
	this.solicitante.set(solicitante);
    }

    public String getEstado() {
	return estado.get();
    }

    public void setEstado(String estado) {
	this.estado.set(estado);
    }

    public StringProperty estadoProperty() {
	return estado;
    }

    public Long getTicket() {
	return ticket.get();
    }

    public void setTicket(Long ticket) {
	this.ticket.set(ticket);
    }

    public LongProperty ticketProperty() {
	return ticket;
    }

    public StringProperty pasajeroProperty() {
	return pasajero;
    }

    public String getFechaEmision() {
	return fechaEmision.get();
    }

    public StringProperty FechaEmisionProperty() {
	return fechaEmision;
    }

    public String getFechaViaje() {
	return fechaViaje.get();
    }

    public StringProperty FechaViajeProperty() {
	return fechaViaje;
    }

    public void setFechaEmision(StringProperty fechaEmision) {
	this.fechaEmision = fechaEmision;
    }

    public void setFechaViaje(StringProperty fechaViaje) {
	this.fechaViaje = fechaViaje;
    }

}
