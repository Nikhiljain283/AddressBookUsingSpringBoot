package com.addressBook.addressBook.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.addressBook.addressBook.DTO.ResponseDTO;
import com.addressBook.addressBook.model.AddressBookModel;
import com.addressBook.addressBook.service.IAddressBookService;

@RestController
public class AddressBookController {

	@Autowired
	IAddressBookService service;

	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addData(@RequestBody @Valid AddressBookDTO contact) {
		AddressBookModel response = service.addDataDb(contact);
		ResponseDTO responseDto = new ResponseDTO("Contact is added successfully", response);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressDetailDbId(@PathVariable int id) {
		AddressBookModel response = service.getdetailById(id);
		ResponseDTO responseDto = new ResponseDTO("Id is found", response);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
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
	public ResponseEntity<ResponseDTO> updateById(@RequestBody @Valid AddressBookDTO data, @PathVariable int id) {
		AddressBookModel response = service.updateDetailById(data, id);
		ResponseDTO responseDto = new ResponseDTO("successfully updated", response);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/state/{state}")
	public ResponseEntity<AddressBookDTO> getContactDetailDbState(@PathVariable String state) {
		List<AddressBookModel> res = service.getContactByState(state);
		ResponseDTO responsedto = new ResponseDTO("Get call by state is successfull", "res");
		return new ResponseEntity(responsedto, HttpStatus.OK);
	}
}
