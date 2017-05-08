package com.concierto.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ENTRADA")
public class Entrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "PRECIO_NETO", nullable = false)
	private double precio_neto;

	@Column(name = "IVA", nullable = false)
	private double iva;

	@Column(name = "SGAE", nullable = false)
	private double sgae;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONCIERTO")
	 @JsonBackReference
	private Concierto concierto;

	public double getPrecio_neto() {
		return precio_neto;
	}

	public void setPrecio_neto(double precio_neto) {
		this.precio_neto = precio_neto;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getSgae() {
		return sgae;
	}

	public void setSgae(double sgae) {
		this.sgae = sgae;
	}

	public Concierto getConcierto() {
		return concierto;
	}

	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}
	
	

}
