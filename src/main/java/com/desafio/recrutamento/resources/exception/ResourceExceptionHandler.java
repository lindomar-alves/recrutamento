package com.desafio.recrutamento.resources.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.recrutamento.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErroPadrao> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest request){
		ErroPadrao erroPadrao = new ErroPadrao(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao); 
	}
	
}
