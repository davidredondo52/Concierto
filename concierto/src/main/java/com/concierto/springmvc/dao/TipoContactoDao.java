package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.TipoContacto;

public interface TipoContactoDao {
	TipoContacto findById(int id);

	void save(TipoContacto TipoContacto);

	void delete(TipoContacto TipoContacto);

	List<TipoContacto> findAll();
}
