package com.sg.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequestMapping(produces = "application/json")
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handleConstraintViolationException(BaseException ex) {
		return new ResponseEntity<Object>(ex.errorMessage, new HttpHeaders(), ex.status);
   }
}
