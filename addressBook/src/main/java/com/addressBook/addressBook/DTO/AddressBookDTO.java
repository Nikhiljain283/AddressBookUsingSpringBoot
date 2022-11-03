package com.addressBook.addressBook.DTO;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.addressBook.addressBook.model.AddressBookModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {
	

	public AddressBookDTO(String string, AddressBookModel response) {
		// TODO Auto-generated constructor stub
	}
	
	@Pattern(regexp = "^[A-z]{1}[a-z]{3,}[ ][a-z]{3,}$", message = "Invalid data")
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private List<String> state;
	private int zipCode;
	private String email;

}
