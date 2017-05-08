package com.concierto.springmvc.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.concierto.springmvc.model.Concierto;
import com.concierto.springmvc.service.ConciertoService;

@RestController
public class ServicioConciertoRest {
	@Autowired
	ConciertoService conciertoService;

	@RequestMapping(value = "/listaConciertosRest", 
			method = RequestMethod.GET)
	public ResponseEntity<List<Concierto>> listaConciertos() {

		List<Concierto> conciertos = conciertoService.findAll();
		
		
		
		  if (conciertos == null || conciertos.isEmpty()){
	            System.out.println("no Concierto found");
	            return new ResponseEntity<List<Concierto>>(HttpStatus.NO_CONTENT);
	        }

	        return new ResponseEntity<List<Concierto>>(conciertos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getConcierto/{id}", 
			method = RequestMethod.GET)
	public ResponseEntity<Concierto> getConciertos(@PathVariable int id) {

		Concierto concierto = conciertoService.findById(id);
		
		return new ResponseEntity<Concierto>(concierto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateConcierto",method=RequestMethod.PUT)	
    public ResponseEntity<Void> actualizaConcierto(Concierto concierto,    UriComponentsBuilder ucBuilder) {
       
 
        Concierto conciertoAux = conciertoService.findById(concierto.getId());
        if (conciertoAux!=null) {
            System.out.println("A Concierto with id " + concierto.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        conciertoService.update(concierto);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/getConcierto/{id}").buildAndExpand(concierto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
}
