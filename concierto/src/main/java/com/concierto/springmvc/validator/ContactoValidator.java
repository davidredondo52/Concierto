package com.concierto.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.concierto.springmvc.model.Contacto;

public class ContactoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Contacto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.nombre.required",
				"El nombre es obligatorio");

	}

}
