package com.concierto.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.concierto.springmvc.model.TipoContacto;

@Repository("tipoContactoDao")
public class TipoContactoDaoImpl implements TipoContactoDao {

	private TipoContactoDao tipoContactoDao;

	public TipoContacto findById(int id) {
		return tipoContactoDao.findById(id);
	}

	public void save(TipoContacto TipoContacto) {
		tipoContactoDao.save(TipoContacto);

	}

	public void delete(TipoContacto TipoContacto) {
		tipoContactoDao.save(TipoContacto);

	}

	public List<TipoContacto> findAll() {
		return tipoContactoDao.findAll();
	}

}
