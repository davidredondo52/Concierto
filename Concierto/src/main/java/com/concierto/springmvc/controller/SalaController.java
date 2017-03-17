package com.concierto.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concierto.springmvc.model.Sala;
import com.concierto.springmvc.service.SalaService;
import com.concierto.springmvc.validator.SalaValidator;

@Controller
public class SalaController {
	@Autowired
	SalaService salaService;

	@Autowired
	MessageSource messageSource;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new SalaValidator());
	}

	/*
	 * This method will list all existing Services.
	 */
	@RequestMapping(value = { "/listSalas" }, method = RequestMethod.GET)
	public String listSalas(ModelMap model) {

		List<Sala> salas = salaService.findAll();
		model.addAttribute("salas", salas);
		return "salas";
	}

	/*
	 * This method will provide the medium to add a new Service.
	 */
	@RequestMapping(value = { "/newSala" }, method = RequestMethod.GET)
	public String newSala(ModelMap model) {
		Sala sala = new Sala();
		model.addAttribute("sala", sala);
		model.addAttribute("edit", false);
		return "altaSala";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving Service in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newSala" }, method = RequestMethod.POST)
	public String saveSala(@Valid Sala sala, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaSala";
		}

		salaService.save(sala);

		model.addAttribute("success", "Sala " + sala.getNombre() + " dada de alta correctamente");

		return "success";
	}

	/*
	 * This method will provide the medium to update an existing Service.
	 */
	@RequestMapping(value = { "/edit-{id}-sala" }, method = RequestMethod.GET)
	public String editSala(@PathVariable Integer id, ModelMap model) {

		Sala sala = salaService.findById(id);
		model.addAttribute("sala", sala);
		model.addAttribute("edit", true);
		return "altaSala";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Service in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-sala" }, method = RequestMethod.POST)
	public String updateSala(@Valid Sala sala, BindingResult result, ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaSala";
		}

		salaService.update(sala);

		model.addAttribute("success", "Sala " + sala.getNombre() + " modificada correctamente");

		return "success";
	}

	/*
	 * This method will delete an Service by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-sala" }, method = RequestMethod.GET)
	public String deleteSala(@PathVariable Integer id) {
		Sala sala = salaService.findById(id);
		salaService.delete(sala);
		return "redirect:/listSalas";
	}

}
