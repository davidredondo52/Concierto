package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.ContactoDao;
import com.concierto.springmvc.model.Contacto;
@Transactional
@Service("contactoService")
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoDao contactoDao;
	public Contacto findById(int id) {
		return contactoDao.findById(id);
	}

	public void save(Contacto Contacto) {
		contactoDao.save(Contacto);

	}

	public void delete(Contacto Contacto) {
		contactoDao.delete(Contacto);

	}

	public List<Contacto> findAll() {
		return contactoDao.findAll();
	}

	@Override
	public void update(Contacto contacto) {
		contactoDao.update(contacto);
		
	}

}
