package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concierto.springmvc.model.Artista;

public interface ArtistaService {

	Artista findById(int id);
	
	void save(Artista artista);
    
    void delete(Artista artista);
     
    List<Artista> findAll();
    
    void update(Artista artista);
    List<Artista> filtra(Artista artista);
    
    public Page<Artista> findAllPage(Pageable pageable);
}
