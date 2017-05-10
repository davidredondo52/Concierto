package com.concierto.springmvc.service;

import java.util.List;

import com.concierto.springmvc.model.Sala;

public interface SalaService {
	Sala findById(int id);

	void save(Sala Sala);

	void delete(Sala Sala);

	List<Sala> findAll();
	
	void update(Sala sala);
}
