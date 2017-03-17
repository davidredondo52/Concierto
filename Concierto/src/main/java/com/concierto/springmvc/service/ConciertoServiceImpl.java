package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.ConciertoDao;
import com.concierto.springmvc.model.Concierto;

@Transactional
@Service("conciertoService")
public class ConciertoServiceImpl implements ConciertoService {

	@Autowired
	private ConciertoDao conciertoDao;

	public Concierto findById(int id) {
		return conciertoDao.findById(id);
	}

	@Transactional
	public void save(Concierto concierto) {
		conciertoDao.save(concierto);

	}

	@Transactional
	public void delete(Concierto concierto) {
		conciertoDao.delete(concierto);

	}

	public List<Concierto> findAll() {
		return conciertoDao.findAll();
	}

	@Transactional
	public void update(Concierto concierto) {
		conciertoDao.update(concierto);
	}

	@Override
	public List<Concierto> filtra(Concierto concierto) {

		return conciertoDao.filtra(concierto);
	}

}
