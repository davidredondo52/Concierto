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

import com.concierto.springmvc.model.Concierto;
import com.concierto.springmvc.model.Entrada;
import com.concierto.springmvc.service.ConciertoService;
import com.concierto.springmvc.service.EntradaService;
import com.concierto.springmvc.validator.EntradaValidator;

@Controller
public class EntradaController {

	@Autowired
	EntradaService entradaService;

	@Autowired
	ConciertoService conciertoService;

	@Autowired
	MessageSource messageSource;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "entradas", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {
				if (element != null) {
					Integer id = Integer.parseInt(element.toString());
					Concierto concierto = conciertoService.findById(id);
					return concierto;

				}
				return null;
			}

		});

		binder.setValidator(new EntradaValidator());
	}

	/*
	 * This method will list all existing entradas.
	 */
	@RequestMapping(value = { "/listEntradas" }, method = RequestMethod.GET)
	public String listEntradas(ModelMap model) {

		List<Entrada> entradas = entradaService.findAll();
		model.addAttribute("entradas", entradas);

		return "entradas";
	}

	/*
	 * This method will provide the medium to add a new entrada.
	 */
	@RequestMapping(value = { "/newEntrada" }, method = RequestMethod.GET)
	public String newEntrada(ModelMap model) {
		Entrada entrada = new Entrada();
		model.addAttribute("entrada", entrada);
		model.addAttribute("edit", false);
		return "altaEntrada";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving entrada in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newEntrada" }, method = RequestMethod.POST)
	public String saveEntrada(@Valid Entrada entrada, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaEntrada";
		}

		entradaService.save(entrada);

		model.addAttribute("success",
				"Entrada " + entrada.getConcierto().getDescripcion() + " dado de alta correctamente");

		return "success";
	}

	/*
	 * This method will provide the medium to update an existing entrada.
	 */
	@RequestMapping(value = { "/edit-{id}-entrada" }, method = RequestMethod.GET)
	public String editEntrada(@PathVariable Integer id, ModelMap model) {

		Entrada entrada = entradaService.findById(id);
		model.addAttribute("entrada", entrada);
		model.addAttribute("edit", true);
		return "altaEntrada";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating entrada in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-entrada" }, method = RequestMethod.POST)
	public String updateEntrada(@Valid Entrada entrada, BindingResult result, ModelMap model,
			@PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaEntrada";
		}

		entradaService.update(entrada);

		model.addAttribute("success",
				"Entrada " + entrada.getConcierto().getDescripcion() + " modificada correctamente");

		return "success";
	}

	/*
	 * This method will delete an entrada by id
	 */
	@RequestMapping(value = { "/delete-{id}-Entrada" }, method = RequestMethod.GET)
	public String deleteEntrada(@PathVariable Integer id) {
		Entrada entrada = entradaService.findById(id);
		entradaService.delete(entrada);
		return "redirect:/listEntradas";
	}

}
