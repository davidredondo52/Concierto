package com.concierto.springmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CONCIERTO")
public class Concierto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, max = 50)
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_sala")	
	private Sala sala;

	@ManyToOne
	@JoinColumn(name = "id_promotor")	
	private Promotor promotor;

	@ManyToMany
	@JoinTable(name = "CONCIERTO_ARTISTA", joinColumns = @JoinColumn(name = "ID_CONCIERTO", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ARTISTA", referencedColumnName = "ID"))
	@Fetch(FetchMode.JOIN)
	@Cascade({ CascadeType.MERGE })	
	private List<Artista> artistas;

	public List<Artista> getArtistas() {
		if (artistas == null)
			artistas = new ArrayList<Artista>();

		return artistas;
	}

	public int getId() {
		return id;
	}

	@Column(name = "FECHA", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;

	@Column(name = "CONTRATO")
	@JsonIgnore
	private byte[] contrato;
	@Column(name = "FILE_NAME")
	private String fileName;
	
	
	
	
	@Transient
	private MultipartFile fichero;
	
	


	

	public MultipartFile getFichero() {
		return fichero;
	}

	public void setFichero(MultipartFile fichero) {
		this.fichero = fichero;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContrato() {
		return contrato;
	}

	public void setContrato(byte[] contrato) {
		this.contrato = contrato;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Promotor getPromotor() {
		return promotor;
	}

	public void setPromotor(Promotor promotor) {
		this.promotor = promotor;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@OneToOne(optional = false, mappedBy = "concierto")	
	@JsonManagedReference
	private Entrada entrada;

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

}
