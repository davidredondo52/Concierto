package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.EntradaDao;
import com.concierto.springmvc.model.Entrada;

@Transactional
@Service("entradaService")
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaDao entradaDao;

	public Entrada findById(int id) {

		return entradaDao.findById(id);
	}

	public void save(Entrada Entrada) {
		entradaDao.save(Entrada);

	}

	public void delete(Entrada Entrada) {
		entradaDao.delete(Entrada);

	}

	public List<Entrada> findAll() {

		return entradaDao.findAll();
	}

	@Override
	public void update(Entrada Entrada) {
		entradaDao.update(Entrada);
		
	}

	

}
