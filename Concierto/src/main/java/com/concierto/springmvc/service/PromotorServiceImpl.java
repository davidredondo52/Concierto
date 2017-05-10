package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.PromotorDao;
import com.concierto.springmvc.model.Promotor;
@Transactional
@Service("promotorService")
public class PromotorServiceImpl implements PromotorService {

	@Autowired
	private PromotorDao promotorDao;
	
	public Promotor findById(int id) {
		return promotorDao.findById(id);
	}

	public void save(Promotor Promotor) {
		promotorDao.save(Promotor);

	}

	public void delete(Promotor Promotor) {
		promotorDao.delete(Promotor);

	}

	public List<Promotor> findAll() {
		return promotorDao.findAll();
	}

	@Override
	public void update(Promotor promotor) {
		promotorDao.update(promotor);
		
	}

}
