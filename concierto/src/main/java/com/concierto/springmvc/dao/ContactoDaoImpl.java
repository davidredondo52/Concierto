package com.concierto.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Contacto;
@Repository("contactoDao")
public class ContactoDaoImpl extends AbstractDao<Integer, Contacto> implements ContactoDao {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	public Contacto findById(int id) {
		return getByKey(id);
	}
	@Transactional
	public void save(Contacto Contacto) {
		persist(Contacto);

	}
	@Transactional
	public void delete(Contacto Contacto) {
		delete(Contacto);

	}

	@SuppressWarnings("unchecked")
	public List<Contacto> findAll() {
		Query query = currentSession().createQuery(  "select model from  Contacto model order by id");
		return query.list();
	}

	@Override
	public void update(Contacto contacto) {
		currentSession().update(contacto);
		
	}

}
