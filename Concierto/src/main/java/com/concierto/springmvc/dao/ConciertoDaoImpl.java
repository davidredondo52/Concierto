package com.concierto.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Concierto;

@Repository("conciertoDao")
public class ConciertoDaoImpl extends AbstractDao<Integer, Concierto> implements ConciertoDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Concierto findById(int id) {

		return getByKey(id);
	}

	public void save(Concierto concierto) {
		persist(concierto);

	}

	@Transactional
	public void delete(Concierto concierto) {
		
		Query query = currentSession().createQuery(
                "delete Concierto where id=:id");
		query.setParameter("id", concierto.getId());
		query.executeUpdate() ;
	

	}

	@SuppressWarnings("unchecked")
	public List<Concierto> findAll() {
		Query query = currentSession().createQuery(  "select model from  Concierto model order by id");
		return query.list();

	}

	@Transactional
	public void update(Concierto concierto) {
		currentSession().update(concierto);
       

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Concierto> filtra(Concierto concierto) {
		String queryTxt=  "select model from  Concierto model where 1=1 ";
		if (!"".equals(concierto.getDescripcion()))
			queryTxt += " and lower(descripcion) like lower('%" + concierto.getDescripcion() + "%')";

		queryTxt += " order by id";
		Query query = currentSession().createQuery(queryTxt);
		return query.list();
		
	}

}
