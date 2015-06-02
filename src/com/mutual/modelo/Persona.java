package com.mutual.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {
    private int dni;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private List<Ticket> tickets;
    private String telefono;
    private String domicilio;
    private String mail;
    private String empresa;
    private String ocupacion;
    private Date fechaAlta;

    @Id
    public int getDni() {
	return dni;
    }

    public void setDni(int dni) {
	this.dni = dni;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getTelefono() {
	return telefono;
    }

    public void setTelefono(String telefono) {
	this.telefono = telefono;
    }

    public String getDomicilio() {
	return domicilio;
    }

    public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public String getEmpresa() {
	return empresa;
    }

    public void setEmpresa(String empresa) {
	this.empresa = empresa;
    }

    public String getOcupacion() {
	return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
	this.ocupacion = ocupacion;
    }

    public Date getFechaAlta() {
	return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
    }

    public Date getFechaNacimiento() {
	return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
    }

    @OneToMany(targetEntity = Ticket.class, mappedBy = "pasajero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Ticket> getTickets() {
	return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
	this.tickets = tickets;
    }

}
