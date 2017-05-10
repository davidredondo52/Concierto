package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.ArtistaDao;
import com.concierto.springmvc.model.Artista;
@Service("artistaService")
@Transactional
public class ArtistaServiceImpl implements ArtistaService {

	
	@Autowired
    private ArtistaDao artistaDao;
	
	public Artista findById(int id) {
		return artistaDao.findById(id)  ;
	}

	@Transactional(value="transactionManagerJPA")
	public void save(Artista artista) {
		artistaDao.save(artista);

	}
	@Transactional(value="transactionManagerJPA")
	public void delete(Artista artista) {
		System.out.println("Delete "+artista.getNombre());
		artistaDao.delete(artista);

	}

	public List<Artista> findAll() {
		return artistaDao.findAll();
	}
	
	@Override
	public Page<Artista> findAllPage(Pageable pageable)
	{
		return artistaDao.findAll(pageable);
	}

	@Override	
	@Transactional(value="transactionManagerJPA")
	public void update(Artista artista) {
		artistaDao.update(artista.getNombre(), artista.getId());
		
	}

	@Override
	public List<Artista> filtra(Artista artista) {
		return artistaDao.findByNombreOrderByNombre(artista.getNombre());
	}

}
