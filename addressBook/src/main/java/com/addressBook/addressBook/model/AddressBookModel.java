package com.addressBook.addressBook.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.addressBook.addressBook.DTO.AddressBookDTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private int zipCode;
	private String email;
	
	@ElementCollection
	@CollectionTable(name = "contact_state", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "state")
	private List<String> state;
	
	public AddressBookModel(AddressBookDTO data) {
		this.fullName = data.getFullName();
		this.address = data.getAddress();
		this.phoneNumber = data.getPhoneNumber();
		this.city = data.getCity();
		this.state = data.getState();
		this.zipCode = data.getZipCode();
		this.email = data.getEmail();
	}
	
}
