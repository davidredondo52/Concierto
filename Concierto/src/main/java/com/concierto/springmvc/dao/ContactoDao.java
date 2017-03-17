package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.Contacto;

public interface ContactoDao {
	Contacto findById(int id);

	void save(Contacto Contacto);

	void delete(Contacto Contacto);

	List<Contacto> findAll();
	
	void update(Contacto contacto);
}
