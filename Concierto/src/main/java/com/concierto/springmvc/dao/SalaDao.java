package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.Sala;

public interface SalaDao {
	Sala findById(int id);

	void save(Sala Sala);

	void delete(Sala Sala);

	List<Sala> findAll();
	
	void update(Sala Sala);
}
