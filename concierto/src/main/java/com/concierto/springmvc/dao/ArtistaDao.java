package com.concierto.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.concierto.springmvc.model.Artista;

public interface ArtistaDao extends JpaRepository<Artista, Integer>

{
	public Artista findById(int id);
	@Modifying
    @Query("Update Artista t SET t.nombre=:nombre WHERE t.id=:id")
	public  void update(@Param("nombre") String nombre,@Param("id") int id);
	
	public List<Artista> findByNombreOrderByNombre(String nombre) ;
	/*
	void save(Artista artista);
    
    void delete(Artista artista);
     
    List<Artista> findAll();
    
  
    
	 List<Artista> filtra(Artista artista);^*/
 
}
