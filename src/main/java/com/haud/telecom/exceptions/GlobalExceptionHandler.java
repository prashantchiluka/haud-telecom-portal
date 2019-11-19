package com.haud.telecom.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<ErrorResponse> entityNotFound(EntityNotFound entityNotFound, WebRequest request){
		return  new ResponseEntity<>(new ErrorResponse(new Date(), entityNotFound.getMessage(), request.getDescription(false) ), HttpStatus.NOT_FOUND );
	}

}
