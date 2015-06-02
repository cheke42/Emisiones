package com.mutual.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {
    private Long numero;
    private Persona pasajero;
    private List<Itinerario> itinerarios;
    private Date fechaEmision;
    private Date fechaViaje;
    private Persona solicitante;
    private Usuario usuario;
    private float tarifaBase;
    private float impuestosVarios;
    private boolean idaVuelta;
    private float taridaAAbonar;
    private float comision;
    private float over;
    private float impuesto;
    private float tarifaAFacturar;

    @Id
    public Long getNumero() {
	return numero;
    }

    public void setNumero(Long numero) {
	this.numero = numero;
    }

    @ManyToOne
    @JoinColumn(name = "pasajero")
    public Persona getPasajero() {
	return pasajero;
    }

    public void setPasajero(Persona pasajero) {
	this.pasajero = pasajero;
    }

    @ManyToMany
    @JoinTable(name = "TICKET_ITINERARIO", joinColumns = { @JoinColumn(name = "numeroTicket") }, inverseJoinColumns = { @JoinColumn(name = "codigoAeropuerto") })
    public List<Itinerario> getItinerarios() {
	return itinerarios;
    }

    public float getTarifaAFacturar() {
	return tarifaAFacturar;
    }

    public void setTarifaAFacturar(float tarifaAFacturar) {
	this.tarifaAFacturar = tarifaAFacturar;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
	this.itinerarios = itinerarios;
    }

    public Date getFechaEmision() {
	return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
	this.fechaEmision = fechaEmision;
    }

    public Date getFechaViaje() {
	return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
	this.fechaViaje = fechaViaje;
    }

    @ManyToOne
    @JoinColumn(name = "solicitante")
    public Persona getSolicitante() {
	return solicitante;
    }

    public float getTaridaAAbonar() {
	return taridaAAbonar;
    }

    public float getComision() {
	return comision;
    }

    public float getOver() {
	return over;
    }

    public float getImpuesto() {
	return impuesto;
    }

    public void setTaridaAAbonar(float taridaAAbonar) {
	this.taridaAAbonar = taridaAAbonar;
    }

    public void setComision(float comision) {
	this.comision = comision;
    }

    public void setOver(float over) {
	this.over = over;
    }

    public void setImpuesto(float impuesto) {
	this.impuesto = impuesto;
    }

    public void setSolicitante(Persona solicitante) {
	this.solicitante = solicitante;
    }

    @ManyToOne
    @JoinColumn(name = "emisor")
    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public float getTarifaBase() {
	return tarifaBase;
    }

    public void setTarifaBase(float tarifaBase) {
	this.tarifaBase = tarifaBase;
    }

    public float getImpuestosVarios() {
	return impuestosVarios;
    }

    public void setImpuestosVarios(float impuestosVarios) {
	this.impuestosVarios = impuestosVarios;
    }

    public boolean isIdaVuelta() {
	return idaVuelta;
    }

    public void setIdaVuelta(boolean idaVuelta) {
	this.idaVuelta = idaVuelta;
    }

    public void calcularValoresFactura() {
	tarifaAFacturar = (tarifaBase + impuesto + (tarifaBase * 0.08f));
	taridaAAbonar = tarifaBase + impuesto;
	comision = tarifaBase * (0.01f);
    }

}
