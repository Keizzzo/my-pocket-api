package br.com.ozzziek.stoncksproject.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Monitora e Controla Tratamento de Exceções
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception e){
        return new ResponseEntity<>(e.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BusinessRulesException.class})
    public ResponseEntity<Object> handleBusinessException(BusinessRulesException e){
        return new ResponseEntity<>(e.getLocalizedMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}
