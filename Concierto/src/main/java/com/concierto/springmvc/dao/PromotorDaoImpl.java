package com.concierto.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.model.Promotor;
@Repository("promotorDao")
public class PromotorDaoImpl extends AbstractDao<Integer, Promotor> implements PromotorDao {

	public Promotor findById(int id) {
		return getByKey(id);
	}
	@Transactional
	public void save(Promotor Promotor) {
		persist(Promotor);

	}
	@Transactional
	public void delete(Promotor Promotor) {
		delete(Promotor);

	}

	@SuppressWarnings("unchecked")
	public List<Promotor> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Promotor>) criteria.list();
	}

	@Override
	@Transactional
	public void update(Promotor promotor) {
		update(promotor);
		
	}

}
