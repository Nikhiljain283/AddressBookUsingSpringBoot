package com.addressBook.addressBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.exception.CustomException;
import com.addressBook.addressBook.model.AddressBookModel;
import com.addressBook.addressBook.repository.AddressBookRepository;
import com.addressBook.addressBook.util.EmailSenderService;
import com.addressBook.addressBook.util.TokenUtil;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	AddressBookRepository repo;
	
	@Autowired 
	TokenUtil tokenUtil;
	
	@Autowired
	EmailSenderService emailSenderService;

	public String addDataDb(AddressBookDTO contact) {
		AddressBookModel response = new AddressBookModel(contact);
		repo.save(response);
		String token = tokenUtil.createToken(response.getId());
		emailSenderService.sendEmail(response.getEmail(), "checking email sender",
				"hii "+response.getFullName()+" localhost:8080/allDetails/{"+token+"}"); 
		return token;
	
	}

	public AddressBookModel getdetailById(String token) {
		int id = tokenUtil.decodeToken(token);
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new CustomException("Contact with " + id + " id is not found in the Address Book");
		}
	}

	public List<AddressBookModel> getDbDetail(String token) {
		int id = tokenUtil.decodeToken(token);
		if (repo.findById(id).isPresent()) {
			return repo.findAll();
		} else {
			throw new CustomException("Id is not present in table");
		}

	}

	public Integer deletedetailsById(String token) {
		int id = tokenUtil.decodeToken(token);
		if (repo.findById(id).isPresent()) {
		repo.deleteById(id);
		return id;
		}else {
			throw new CustomException("Contact with "+id+" id is not found");
		}

	}

	public AddressBookModel updateDetailById(AddressBookDTO model, String token) {
		int id = tokenUtil.decodeToken(token);
		if (repo.findById(id).isPresent()) {
			AddressBookModel existingData = repo.findById(id).get();
			existingData.setFullName(model.getFullName());
			AddressBookModel res = repo.save(existingData);
			return res;
		} else {
			throw new CustomException("Contact with " + id + " id is not found in the Address Book");
		}
	}

	@Override
	public List<AddressBookModel> getContactByState(String state) {
		return repo.findByState(state);
	}

}
