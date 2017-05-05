package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.ArtistaDao;
import com.concierto.springmvc.model.Artista;
@Service("artistaService")
public class ArtistaServiceImpl implements ArtistaService {

	
	@Autowired
    private ArtistaDao artistaDao;
	
	public Artista findById(int id) {
		return artistaDao.findById(id)  ;
	}

	@Transactional
	public void save(Artista artista) {
		artistaDao.save(artista);

	}
	@Transactional
	public void delete(Artista artista) {
		artistaDao.delete(artista);

	}

	public List<Artista> findAll() {
		return artistaDao.findAll();
	}

	@Override
	@Transactional
	public void update(Artista artista) {
		artistaDao.update(artista.getNombre(), artista.getId());
		
	}

	@Override
	public List<Artista> filtra(Artista artista) {
		return artistaDao.findByNombreOrderByNombre(artista.getNombre());
	}

}
