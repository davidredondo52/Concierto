package com.concierto.springmvc.validator;

import java.io.IOException;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.concierto.springmvc.model.Concierto;

public class ConciertoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Concierto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Concierto concierto = (Concierto) target;

		


		MultipartFile file = concierto.getFichero();
		
		System.out.println("*******************concierto" + concierto);

		



		if (file == null) {
			System.out.println("**************CONTRATO NULO");
		} else {
			System.out.println("**************contrato length=>" + file.getName());
			try {
				concierto.setContrato(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			concierto.setFileName(file.getOriginalFilename());
			System.out.println("**************file=>" + file + " file name=>" + file.getOriginalFilename()
					+ " file contenttype" + file.getContentType());

		}

		/*
		 * if (fichero == null) { errors.rejectValue("contrato",
		 * "contrato.empty"); } else {
		 * System.out.println("**************fichero length=>" +
		 * fichero.getSize() + " name=>" + fichero.getName() + " content=" +
		 * fichero.getContentType()); try {
		 * System.out.println("**************fichero inputstream=>" +
		 * fichero.getInputStream() + " originalName=>" +
		 * fichero.getOriginalFilename()); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */
		// EL NOMBRE es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "field.concierto.descripcion.required",
				"El nombre es obligatorio");

		// el promotor es obligatorio
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "promotor.nombre", "field.promotor.required",
				"El promotor es obligatorio");

		if (!"".equals(concierto.getPromotor().getNombre()) && concierto.getPromotor().getId() == 0) {
			ValidationUtils.rejectIfEmpty(errors, "promotor.id", "Tiene que seleccionar un promotor existente");
		}

		// la sala es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sala.nombre", "field.sala.required",
				"La sala es obligatoria");

		if (!"".equals(concierto.getSala().getNombre()) && concierto.getSala().getId() == 0) {
			ValidationUtils.rejectIfEmpty(errors, "sala.id", "Tiene que seleccionar una sala existente");
		}

		// la fecha es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "field.fecha.required", "La fecha es obligatoria");

	}

}
