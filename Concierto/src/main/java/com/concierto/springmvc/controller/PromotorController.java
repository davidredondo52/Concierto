package com.concierto.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concierto.springmvc.model.Promotor;
import com.concierto.springmvc.service.PromotorService;

@Controller
public class PromotorController {
	@Autowired
	PromotorService promotorService;

	@Autowired
	MessageSource messageSource;

	
	@RequestMapping(value = {"/listPromotores" }, method = RequestMethod.GET)
	public String listPromotor(ModelMap model) {

		List<Promotor> promotores = promotorService.findAll();
		model.addAttribute("promotores", promotores);
		return "promotores";
	}

	/*
	 * This method will provide the medium to add a new promotor.
	 */
	@RequestMapping(value = { "/newPromotor" }, method = RequestMethod.GET)
	public String newPromotor(ModelMap model) {
		Promotor promotor = new Promotor();
		model.addAttribute("promotor", promotor);
		model.addAttribute("edit", false);
		return "altaPromotor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newPromotor" }, method = RequestMethod.POST)
	public String savePromotor(@Valid Promotor promotor, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "altaPromotor";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be
		 * implementing custom @Unique annotation and applying it on field [ssn]
		 * of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 * 
		 * 
		 * if(!service.isEmployeeSsnUnique(employee.getId(),
		 * employee.getSsn())){ FieldError ssnError =new
		 * FieldError("employee","ssn",messageSource.getMessage(
		 * "non.unique.ssn", new String[]{employee.getSsn()},
		 * Locale.getDefault())); result.addError(ssnError); return
		 * "registration"; }
		 */
		promotorService.save(promotor);

		model.addAttribute("success", "Promotor " + promotor.getNombre() + " dado de alta correctamente");
		
		return "success";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-promotor" }, method = RequestMethod.GET)
	public String editPromotor(@PathVariable Integer id, ModelMap model) {
		Promotor promotor = promotorService.findById(id);
		model.addAttribute("promotor", promotor);
		model.addAttribute("edit", true);
		return "altaPromotor";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-promotor" }, method = RequestMethod.POST)
	public String updatePromotor(@Valid Promotor promotor, BindingResult result, ModelMap model,
			@PathVariable Integer id) {

		if (result.hasErrors()) {
			return "altaPromotor";
		}

		/*
		 * if(!service.isEmployeeSsnUnique(employee.getId(),
		 * employee.getSsn())){ FieldError ssnError =new
		 * FieldError("employee","ssn",messageSource.getMessage(
		 * "non.unique.ssn", new String[]{employee.getSsn()},
		 * Locale.getDefault())); result.addError(ssnError); return
		 * "registration"; }
		 */

		promotorService.update(promotor);

		model.addAttribute("success", "Promotor " + promotor.getNombre() + " dado de alta correctamente");
		
		return "success";
	}

	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-promotor" }, method = RequestMethod.GET)
    public String deletePromotor(@PathVariable Promotor promotor) {
		promotorService.delete(promotor);
        return "redirect:/listPromotor";
    }
}
