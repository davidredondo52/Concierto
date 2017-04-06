package com.concierto.springmvc.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.concierto.springmvc.model.Concierto;

public class FormularioConcierto {

	private Concierto concierto;
	private CommonsMultipartFile fichero;

	public Concierto getConcierto() {
		return concierto;
	}

	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}

	public CommonsMultipartFile getFichero() {
		return fichero;
	}

	public void setFichero(CommonsMultipartFile fichero) {
		this.fichero = fichero;
	}

}
