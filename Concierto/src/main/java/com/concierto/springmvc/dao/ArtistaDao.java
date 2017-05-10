package com.concierto.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Artista;


public interface ArtistaDao extends JpaRepository<Artista, Integer>

{
	public Artista findById(int id);

	@Modifying(clearAutomatically = true)
	@Query("Update Artista t SET t.nombre=:nombre WHERE t.id=:id")
	public void update(@Param("nombre") String nombre, @Param("id") int id);

	public List<Artista> findByNombreOrderByNombre(String nombre);

}
