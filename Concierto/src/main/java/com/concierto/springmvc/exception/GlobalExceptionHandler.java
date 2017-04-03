package com.concierto.springmvc.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = MultipartException.class)
	public String handleMultipartException(Exception ex, HttpServletRequest request) {

		FlashMap flash = RequestContextUtils.getOutputFlashMap(request);
		if (ex instanceof MultipartException) {
			MultipartException mEx = (MultipartException) ex;
			System.out.println("ERROR ex.getCause()***************" + ex.getCause());
			flash.put("errors", ex.getCause());
			if (ex.getCause() instanceof FileUploadBase.FileSizeLimitExceededException) {
				System.out.println("DENTRO ERROR ex.getCause()***************" + ex.getCause());
				FileUploadBase.FileSizeLimitExceededException flEx = (FileUploadBase.FileSizeLimitExceededException) mEx
						.getCause();
				float permittedSize = flEx.getPermittedSize() / 1024;
				String message = messageSource.getMessage("file.maxsize", new Object[] { "Contrato", permittedSize },
						LocaleContextHolder.getLocale());
				System.out.println("ERROR MESSAGE***************" + message);
				flash.put("errors", message);

			} else {
				flash.put("errors", "Please contact administrator: " + ex.getMessage());
			}
		} else {
			flash.put("errors", "Please contact administrator: " + ex.getMessage());
		}
		return "error";
	}

	@ExceptionHandler(value = IOException.class)
	public RedirectView handleIOException(Exception ex, HttpServletRequest request) {
		RedirectView model = new RedirectView("error");
		FlashMap flash = RequestContextUtils.getOutputFlashMap(request);
		flash.put("errors", "Please contact administrator: " + ex.getMessage());
		return model;
	}
}
