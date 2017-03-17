package com.concierto.springmvc.dao;

import java.util.List;

import com.concierto.springmvc.model.Artista;

public interface ArtistaDao {
	Artista findById(int id);
	
	void save(Artista artista);
    
    void delete(Artista artista);
     
    List<Artista> findAll();
    
    void update(Artista artista);
    
	 List<Artista> filtra(Artista artista);
 
}
