package com.example.spring_mongo_first.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.spring_mongo_first.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException onfe, HttpServletRequest request){
		String error = "Ojecto não encontrado";
		String path = request.getRequestURI();
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError stdError = new StandardError(System.currentTimeMillis(),status.value(), onfe.getMessage(), error, path);
		return ResponseEntity.status(status).body(stdError);
	}

}
