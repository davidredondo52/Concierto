package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.Promotor;

public interface PromotorDao {
	Promotor findById(int id);

	void save(Promotor Promotor);

	void delete(Promotor Promotor);

	List<Promotor> findAll();
	
	void update(Promotor Promotor);
}
