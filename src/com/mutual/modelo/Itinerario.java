package com.mutual.modelo;
// Prueba
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITINERARIO")
public class Itinerario {
	private int idItinerario;
	private String codigoAeropuerto;
	private String nombreAeropuerto;
	private List<Ticket> tickets;

	public String getCodigoAeropuerto() {
		return codigoAeropuerto;
	}

	public void setCodigoAeropuerto(String codigoAeropuerto) {
		this.codigoAeropuerto = codigoAeropuerto;
	}

	@Id
	@GeneratedValue
	public int getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	@ManyToMany
	@JoinTable(name = "TICKET_ITINERARIO", joinColumns = { @JoinColumn(name = "codigoAeropuerto") }, inverseJoinColumns = { @JoinColumn(name = "numeroTicket") })
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
