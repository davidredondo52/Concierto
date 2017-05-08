package com.concierto.springmvc.service;

import java.util.List;

import com.concierto.springmvc.model.Contacto;

public interface ContactoService {
	Contacto findById(int id);

	void save(Contacto Contacto);

	void delete(Contacto Contacto);

	List<Contacto> findAll();
	
	void update(Contacto contacto);
}
