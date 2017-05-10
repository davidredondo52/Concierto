package com.concierto.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concierto.springmvc.model.Artista;
import com.concierto.springmvc.model.Concierto;
import com.concierto.springmvc.model.Promotor;
import com.concierto.springmvc.model.Sala;
import com.concierto.springmvc.model.Tag;
import com.concierto.springmvc.service.ArtistaService;
import com.concierto.springmvc.service.ConciertoService;
import com.concierto.springmvc.service.PromotorService;
import com.concierto.springmvc.service.SalaService;

@Controller
public class TagController {
	List<Tag> data = new ArrayList<Tag>();

	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private PromotorService promotorService;
	@Autowired
	private SalaService salaService;

	@Autowired
	private ConciertoService conciertoService;

	@RequestMapping(value = "/getTags", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody List<Tag> getTags(@RequestParam("tagName") String tagName,
			@RequestParam("valor") String valor) {

		return simulateSearchResult(tagName, valor);

	}

	private List<Tag> simulateSearchResult(String tagName, String valor) {

		List<Tag> result = new ArrayList<Tag>();
		if (tagName.equals("artista")) {
			Artista a = new Artista();
			a.setNombre(valor);
			List<Artista> artistas = artistaService.filtra(a);
			for (Artista artista : artistas) {
				String nombreArtista = artista.getNombre().toUpperCase();
				if (nombreArtista.toUpperCase().contains(valor.toUpperCase())) {
					Tag tag = new Tag(artista.getId(), artista.getNombre());
					result.add(tag);
				}
			}

		}
		if (tagName.equals("promotor")) {
			List<Promotor> promotores = promotorService.findAll();
			for (Promotor promotor : promotores) {
				String nombrePromotor = promotor.getNombre().toUpperCase();

				if (nombrePromotor.contains(valor.toUpperCase())) {
					Tag tag = new Tag(promotor.getId(), promotor.getNombre());
					result.add(tag);
				}
			}

		}

		if (tagName.equals("sala")) {
			List<Sala> salas = salaService.findAll();
			for (Sala sala : salas) {

				String nombreSala = sala.getNombre().toUpperCase();
				if (nombreSala.contains(valor.toUpperCase())) {
					Tag tag = new Tag(sala.getId(), sala.getNombre());
					result.add(tag);
				}
			}
		}

		if (tagName.equals("concierto")) {
			Concierto conciert = new Concierto();
			conciert.setDescripcion(valor);
			List<Concierto> conciertos = conciertoService.filtra(conciert);

			for (Concierto concierto : conciertos) {

				String nombre = concierto.getDescripcion().toUpperCase();

				if (nombre.contains(valor.toUpperCase())) {
					Tag tag = new Tag(concierto.getId(), concierto.getDescripcion());
					result.add(tag);
				}
			}
		}
		System.out.println("result=>" + result.size());
		return result;
	}

}
