package com.concierto.springmvc.controller;

import java.util.Arrays;
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

import com.concierto.springmvc.model.Contacto;
import com.concierto.springmvc.model.TipoContacto;
import com.concierto.springmvc.service.ContactoService;
import com.concierto.springmvc.validator.ContactoValidator;

@Controller
public class ContactoController {
	@Autowired
	ContactoService contactoService;

	@Autowired
	MessageSource messageSource;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ContactoValidator());
    }

	/*
	 * This method will list all existing Contactos.
	 */
	@RequestMapping(value = {  "/listContactos" }, method = RequestMethod.GET)
	public String listContactos(ModelMap model) {

		List<Contacto> Contactos = contactoService.findAll();
		
		model.addAttribute("contactos", Contactos);
		return "contactos";
	}

	/*
	 * This method will provide the medium to add a new Contacto.
	 */
	@RequestMapping(value = { "/newContacto" }, method = RequestMethod.GET)
	public String newContacto(ModelMap model) {
		Contacto Contacto = new Contacto();
		model.addAttribute("contacto", Contacto);
		model.addAttribute ("tipos", Arrays.asList(TipoContacto.values()));
		model.addAttribute("edit", false);
		return "altaContacto";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving Contacto in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newContacto" }, method = RequestMethod.POST)
	public String saveContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaContacto";
		}

		
		contactoService.save(contacto);

		model.addAttribute("success", "Contacto " + contacto.getNombre() + " dado de alta correctamente");
		
		return "success";
	}

	/*
	 * This method will provide the medium to update an existing Contacto.
	 */
	@RequestMapping(value = { "/edit-{id}-contacto" }, method = RequestMethod.GET)
	public String editContacto(@PathVariable Integer id, ModelMap model) {
		
		Contacto contacto = contactoService.findById(id);
		model.addAttribute("contacto", contacto);
		model.addAttribute ("tipos", Arrays.asList(TipoContacto.values()));
		model.addAttribute("edit", true);
		return "altaContacto";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Contacto in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-contacto" }, method = RequestMethod.POST)
	public String updateContacto(@Valid Contacto contacto, BindingResult result, ModelMap model,
			@PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaContacto";
		}


		contactoService.update(contacto);
		

		model.addAttribute("success", "Contacto " + contacto.getNombre() + " modificado correctamente");
		
		return "success";
	}

	/*
	 * This method will delete an Contacto by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-contacto" }, method = RequestMethod.GET)
	public String deleteContacto(@PathVariable Integer id) {
		Contacto contacto = contactoService.findById(id);
		contactoService.delete(contacto);
		return "redirect:/listContactos";
	}

}
