package com.concierto.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concierto.springmvc.dao.TipoContactoDao;
import com.concierto.springmvc.model.TipoContacto;
@Transactional
@Service("tipoContactoService")
public class TipoContactoServiceImpl implements TipoContactoService {

	@Autowired
	private TipoContactoDao tipoContactoDao;
	
	public TipoContacto findById(int id) {
		return tipoContactoDao.findById(id);
	}

	public void save(TipoContacto TipoContacto) {
		tipoContactoDao.save(TipoContacto);

	}

	public void delete(TipoContacto TipoContacto) {
		tipoContactoDao.delete(TipoContacto);

	}

	public List<TipoContacto> findAll() {
		return tipoContactoDao.findAll();
	}

}
