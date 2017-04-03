package com.concierto.springmvc.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concierto.springmvc.model.Concierto;
import com.concierto.springmvc.service.ConciertoService;

@RestController
public class ServicioConciertoRest {
	@Autowired
	ConciertoService conciertoService;

	@RequestMapping(value = "/listaConciertosRest", method = RequestMethod.GET)
	public List<Concierto> listaConciertos() {

		List<Concierto> conciertos = conciertoService.findAll();

		return conciertos;
	}
}
