package com.concierto.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.concierto.springmvc.model.Concierto;

public class ConciertoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Concierto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Concierto concierto = (Concierto) target;
		
		// la matrícula es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.descripcion.required",
				"El nombre es obligatorio");

		// el promotor es obligatorio
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotor.nombre", "field.promotor.required",
				"El promotor es obligatorio");

		if (!"".equals(concierto.getPromotor().getNombre()) && concierto.getPromotor().getId()==0) {
			ValidationUtils.rejectIfEmpty(errors, "promotor.id", "Tiene que seleccionar un promotor existente");
		}

		// la sala es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sala.nombre", "field.sala.required",
				"La sala es obligatoria");

		if (!"".equals(concierto.getSala().getNombre()) && concierto.getSala().getId()==0) {
			ValidationUtils.rejectIfEmpty(errors, "sala.id", "Tiene que seleccionar una sala existente");
		}

		
	
		// la fecha es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "field.fecha.required", "La fecha es obligatoria");

		

	}

}
