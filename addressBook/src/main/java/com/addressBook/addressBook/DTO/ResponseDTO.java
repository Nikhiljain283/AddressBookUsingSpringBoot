package com.addressBook.addressBook.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
	

	private String message;
	private Object dataObject;
	
	public ResponseDTO(String message, Object response) {
		this.message = message;
		this.dataObject = response;
	}

}
