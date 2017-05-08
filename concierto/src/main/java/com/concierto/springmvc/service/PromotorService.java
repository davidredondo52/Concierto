package com.concierto.springmvc.service;

import java.util.List;

import com.concierto.springmvc.model.Promotor;

public interface PromotorService {
	Promotor findById(int id);

	void save(Promotor Promotor);

	void delete(Promotor Promotor);

	List<Promotor> findAll();

	void update(Promotor promotor);
}
