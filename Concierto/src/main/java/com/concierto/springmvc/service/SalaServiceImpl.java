package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.SalaDao;
import com.concierto.springmvc.model.Sala;
@Transactional
@Service("salaService")
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaDao salaDao;
	public Sala findById(int id) {
		return salaDao.findById(id);
	}

	@Transactional
	public void save(Sala Sala) {
		salaDao.save(Sala);

	}
	@Transactional
	public void delete(Sala Sala) {
		salaDao.delete(Sala);

	}

	public List<Sala> findAll() {
		return salaDao.findAll();
	}

	
	@Transactional
	public void update(Sala sala) {
		salaDao.update(sala);
		
	}

}
