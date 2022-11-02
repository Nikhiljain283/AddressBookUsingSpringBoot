package com.addressBook.addressBook.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {
	
	private int id;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;

}
