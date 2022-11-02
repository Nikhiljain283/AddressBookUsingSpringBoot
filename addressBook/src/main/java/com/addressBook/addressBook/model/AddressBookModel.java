package com.addressBook.addressBook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.addressBook.addressBook.DTO.AddressBookDTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;
	
	public AddressBookModel(AddressBookDTO data) {
		this.fullName = data.getFullName();
		this.address = data.getAddress();
		this.phoneNumber = data.getPhoneNumber();
		this.city = data.getCity();
		this.state = data.getCity();
		this.zipCode = data.getZipCode();
		this.email = data.getEmail();
	}
	
}
