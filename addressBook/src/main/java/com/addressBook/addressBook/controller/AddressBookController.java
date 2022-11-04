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
	public ResponseEntity<ResponseDTO> addData(@Valid @RequestBody AddressBookDTO contact) {
		String response = service.addDataDb(contact);
		ResponseDTO responseDto = new ResponseDTO("Contact is added successfully", response);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

	}
	// eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyfQ.2GWs2GRwcJ4zFnSZdil-OMZT8bMgYxJGKRRtO79IMC8

	@GetMapping("/get/{token}")
	public ResponseEntity<ResponseDTO> getAddressDetailDbId(@PathVariable String token) {
		AddressBookModel response = service.getdetailById(token);
		ResponseDTO responseDto = new ResponseDTO("Id is found", response);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/allDetails")
	public ResponseEntity<ResponseDTO> getAll() {
		List<AddressBookModel> response = service.getDbDetail();
		ResponseDTO responseDTO = new ResponseDTO("All User details found!", response);
		return new ResponseEntity(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{token}")
	public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable String token) {
		Integer response = service.deletedetailsById(token);
		ResponseDTO responseDTO = new ResponseDTO("User details is deleted!", response);
		return new ResponseEntity<>(responseDTO, HttpStatus.GONE);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateById(@Valid @RequestBody AddressBookDTO data, @PathVariable String token) {
		AddressBookModel response = service.updateDetailById(data, token);
		ResponseDTO responseDto = new ResponseDTO("successfully updated", response);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/state/{state}")
	public ResponseEntity<AddressBookDTO> getContactDetailDbState(@PathVariable String state) {
		List<AddressBookModel> res = service.getContactByState(state);
		ResponseDTO responsedto = new ResponseDTO("Get call by state is successfull", res);
		return new ResponseEntity(responsedto, HttpStatus.OK);
	}
}
