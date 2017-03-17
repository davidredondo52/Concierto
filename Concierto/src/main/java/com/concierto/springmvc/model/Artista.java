package com.concierto.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ARTISTA")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 50)
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

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

	/*@ManyToMany(mappedBy = "artistas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Concierto> conciertos;

	public List<Concierto> getConciertos() {
		if (conciertos == null)
			conciertos = new ArrayList<Concierto>();

		return conciertos;
	}

	public void setConciertos(List<Concierto> conciertos) {
		this.conciertos = conciertos;
	}*/
	
	public String toString(){
		return this.getId() +":"+this.getNombre();
	}

}
