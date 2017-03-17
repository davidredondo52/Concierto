package com.concierto.springmvc.service;

import java.util.List;

import com.concierto.springmvc.model.TipoContacto;

public interface TipoContactoService {
	TipoContacto findById(int id);

	void save(TipoContacto TipoContacto);

	void delete(TipoContacto TipoContacto);

	List<TipoContacto> findAll();
}
