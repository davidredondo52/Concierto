package com.concierto.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CONTACTO")
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 50)
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Size(max = 50)
	@Column(name = "APELLIDO1", nullable = false)
	private String apellido1;
	@Size(max = 50)
	@Column(name = "APELLIDO2", nullable = false)
	private String apellido2;

	@Size(max = 50)
	@Column(name = "MAIL", nullable = false)
	private String mail;

	@Size(max = 12)
	@Column(name = "TELEFONO", nullable = false)
	private String telefono;

	@Column(name = "TIPO", nullable = false, length = 8)
	@Enumerated(value = EnumType.STRING)
	private TipoContacto tipoContacto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	
	

}
