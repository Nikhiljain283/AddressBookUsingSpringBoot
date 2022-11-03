package com.addressBook.addressBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.addressBook.addressBook.DTO.ResponseDTO;

@ControllerAdvice
public class MyExceptionalHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDTO> handleNonExistingId(CustomException customException){
		ResponseDTO responseDto = new ResponseDTO("Exception while parsing rest request", customException.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
		
	}

}
