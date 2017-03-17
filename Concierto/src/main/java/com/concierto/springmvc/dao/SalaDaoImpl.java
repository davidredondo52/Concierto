package com.concierto.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Sala;
@Repository("salaDao")
public class SalaDaoImpl extends AbstractDao<Integer, Sala> implements SalaDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Sala findById(int id) {
		
		return getByKey(id);
	}
	@Transactional
	public void save(Sala Sala) {
		persist(Sala);

	}
	@Transactional
	public void delete(Sala Sala) {
		delete(Sala);

	}

	@SuppressWarnings("unchecked")
	public List<Sala> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Sala>) criteria.list();
	}


	@Transactional
	public void update(Sala sala) {
		currentSession().update(sala);
		
	}

}
