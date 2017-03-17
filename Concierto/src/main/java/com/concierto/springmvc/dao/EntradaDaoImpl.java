package com.concierto.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Entrada;

@Repository("entradaDao")
public class EntradaDaoImpl extends AbstractDao<Integer, Entrada> implements EntradaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Entrada findById(int id) {

		return getByKey(id);
	}

	public void save(Entrada Entrada) {
		persist(Entrada);

	}

	public void delete(Entrada Entrada) {
		delete(Entrada);

	}

	@SuppressWarnings("unchecked")
	public List<Entrada> findAll() {
		Query query = currentSession().createQuery(  "select model from  Entrada model order by id");
		return query.list();

		
	}
	
	@Transactional
	public void update(Entrada entrada) {
		currentSession().update(entrada);
       

	}

}
