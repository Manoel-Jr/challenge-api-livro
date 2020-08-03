package br.com.api.exception.handler;

import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ResouceExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> Exception(Exception ex) {
		ApiError erro = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiError> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex){
	ApiError erro = new ApiError(HttpStatus.NOT_FOUND.value() , "id do Livro não foi Encontrado", new Date());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
