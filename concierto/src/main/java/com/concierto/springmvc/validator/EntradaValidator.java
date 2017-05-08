package com.concierto.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.concierto.springmvc.model.Entrada;

public class EntradaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Entrada.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		
		// la matrícula es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "concierto.descripcion", "field.concierto.descripcion.required",
				"El concierto es obligatorio");

		// el promotor es obligatorio
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio_neto", "field.precio_neto.required",
				"El precio es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iva", "field.iva.required",
				"El IVA es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sgae", "field.sgae.required",
				"El porcentaje de la SGAE es obligatorio");

		
		

	}

}
