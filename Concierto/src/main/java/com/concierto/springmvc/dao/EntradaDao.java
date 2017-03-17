package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.Entrada;

public interface EntradaDao {
	Entrada findById(int id);

	void save(Entrada Entrada);

	void delete(Entrada Entrada);

	List<Entrada> findAll();

	void update(Entrada Entrada);
}
