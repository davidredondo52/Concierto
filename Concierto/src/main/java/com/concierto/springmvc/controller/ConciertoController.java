package com.concierto.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concierto.springmvc.model.Artista;
import com.concierto.springmvc.model.Concierto;
import com.concierto.springmvc.service.ArtistaService;
import com.concierto.springmvc.service.ConciertoService;
import com.concierto.springmvc.validator.ConciertoValidator;

@Controller
public class ConciertoController {

	@Autowired
	ConciertoService conciertoService;

	@Autowired
	ArtistaService artistaService;

	@Autowired
	MessageSource messageSource;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "artistas", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {
				if (element != null) {
					Integer id = Integer.parseInt(element.toString());
					Artista artista = artistaService.findById(id);
					return artista;

				}
				return null;
			}

		});

		binder.setValidator(new ConciertoValidator()); // registramos el
														// validador
	}

	/*
	 * This method will list all existing employees.
	 */
	// @RequestMapping(value = { "/", "/listConciertos" }, method =
	// RequestMethod.GET)
	@RequestMapping(value = { "/listConciertos" }, method = RequestMethod.GET)
	public String listConciertos(ModelMap model) {

		List<Concierto> conciertos = conciertoService.findAll();
		model.addAttribute("conciertos", conciertos);
		return "conciertos";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/newConcierto" }, method = RequestMethod.GET)
	public String newConcierto(ModelMap model) {
		Concierto concierto = new Concierto();
		model.addAttribute("concierto", concierto);
		model.addAttribute("edit", false);
		return "altaConcierto";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newConcierto" }, method = RequestMethod.POST)
	public String saveConcierto(@Valid Concierto concierto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaConcierto";
		}

		conciertoService.save(concierto);

		model.addAttribute("success", "Concierto " + concierto.getDescripcion() + " dado de alta correctamente");

		return "success";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-concierto" }, method = RequestMethod.GET)
	public String editConcierto(@PathVariable Integer id, ModelMap model) {

		Concierto concierto = conciertoService.findById(id);
		model.addAttribute("concierto", concierto);
		model.addAttribute("edit", true);
		return "altaConcierto";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-concierto" }, method = RequestMethod.POST)
	public String updateConcierto(@Valid Concierto concierto, BindingResult result, ModelMap model,
			@PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaConcierto";
		}

		conciertoService.update(concierto);

		model.addAttribute("success", "Concierto " + concierto.getDescripcion() + " modificado correctamente");

		return "success";
	}

	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-concierto" }, method = RequestMethod.GET)
	public String deleteConcierto(@PathVariable Integer id) {
		Concierto concierto = conciertoService.findById(id);
		conciertoService.delete(concierto);
		return "redirect:/listConciertos";
	}

}
