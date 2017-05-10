package com.concierto.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concierto.springmvc.model.Artista;
import com.concierto.springmvc.pagination.utils.PageWrapper;
import com.concierto.springmvc.service.ArtistaService;

@Controller
public class ArtistaController {
	@Autowired
	ArtistaService artistaService;

	@Autowired
	MessageSource messageSource;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// binder.setValidator(new ArtistaValidator());
	}

	/*
	 * This method will list all existing Artistas.
	 */
	@RequestMapping(value = { "/listArtistas" }, method = RequestMethod.GET)
	public String listartistas(ModelMap model) {

		List<Artista> artistas = artistaService.findAll();

		model.addAttribute("artistas", artistas);
		return "artistas";
	}

	/*
	 * This method will provide the medium to add a new Artista.
	 */
	@RequestMapping(value = { "/newArtista" }, method = RequestMethod.GET)
	public String newArtista(ModelMap model) {
		Artista artista = new Artista();
		model.addAttribute("artista", artista);
		model.addAttribute("edit", false);
		return "altaArtista";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving Artista in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newArtista" }, method = RequestMethod.POST)
	public String saveArtista(@Valid Artista artista, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaArtista";
		}

		artistaService.save(artista);

		model.addAttribute("success", "Artista " + artista.getNombre() + " dado de alta correctamente");

		return "success";
	}

	/*
	 * This method will provide the medium to update an existing Artista.
	 */
	@RequestMapping(value = { "/edit-{id}-artista" }, method = RequestMethod.GET)
	public String editArtista(@PathVariable Integer id, ModelMap model) {

		Artista artista = artistaService.findById(id);
		model.addAttribute("artista", artista);
		model.addAttribute("edit", true);
		return "altaArtista";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating Artista in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-artista" }, method = RequestMethod.POST)
	public String updateartista(@Valid Artista artista, BindingResult result, ModelMap model,
			@PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaArtista";
		}

		artistaService.update(artista);

		model.addAttribute("success", "Artista " + artista.getNombre() + " modificado correctamente");

		return "success";
	}

	/*
	 * This method will delete an Artista by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-artista" }, method = RequestMethod.GET)
	public String deleteartista(@PathVariable Integer id) {
		Artista artista = artistaService.findById(id);
		artistaService.delete(artista);
		return "redirect:/listArtistasPag/0";
	}

	// Paginado
	@RequestMapping(value = { "/listArtistasPag/{pag}" }, method = RequestMethod.GET)
	public String listArtistasPag(@PathVariable Integer pag, ModelMap model) {

		// Pageable pg = new PageRequest(pag, PageWrapper.MAX_PAGE_ITEM_DISPLAY,
		// Direction.ASC, "nombre");
		Pageable pg = new PageRequest(pag, 3, Direction.ASC, "nombre");
		Page<Artista> artistasPag = artistaService.findAllPage(pg);
		// Envoltorio de la pagina para poder hacer la paginacion
		PageWrapper<Artista> page = new PageWrapper<Artista>(artistasPag, "/listArtistasPag");

		
		model.addAttribute("pagina", page);

		return "artistasPag";
	}
}
