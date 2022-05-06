package com.zensar.stockapplication.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/*@ExceptionHandler(InvalidStockIdException.class)
	public ResponseEntity<Object> handleStockError(RuntimeException exception,WebRequest request){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}*/
	
	@ExceptionHandler(InvalidStockIdException.class)
	public ResponseEntity<CustomErrorResponse> handleStockError(HttpServletResponse response) throws IOException{
		//response.sendError(400);
		System.out.println("I am inside ResponseEntity<CustomErrorResponse> handleStockError ");
		CustomErrorResponse response2=new CustomErrorResponse();
		
		response2.setTimestamp(LocalDateTime.now());
		response2.setStatus(400);
		response2.setError("Invalid ID");
		
		return new ResponseEntity<CustomErrorResponse>(response2,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
