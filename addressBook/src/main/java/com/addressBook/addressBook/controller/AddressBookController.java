package com.addressBook.addressBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.model.AddressBookModel;
import com.addressBook.addressBook.service.IAddressBookService;


@RestController
public class AddressBookController {
	
	@Autowired
	IAddressBookService service;
	
	@PostMapping("/add")
	public AddressBookModel addData(@RequestBody AddressBookDTO data) {
		AddressBookModel response = service.addDataDb(data);
		return response;
		
	}
	
	@GetMapping("/get/{id}")
	public AddressBookModel getAddressDetailDbId(@PathVariable int id) {
		AddressBookModel response = service.getdetailById(id);
		return response;
	}
	
	@GetMapping("/getAll")
	public List<AddressBookModel> getAllDetails() {
		List<AddressBookModel> response = service.getDbDetail();
		return response;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deletedetailsById(id);
	}
	
	@PutMapping("/update/{id}")
	public AddressBookModel updateById(@RequestBody AddressBookDTO data, @PathVariable int id) {
	AddressBookModel response = service.updateDetailById(data, id);
	return response;
	}
	

}
