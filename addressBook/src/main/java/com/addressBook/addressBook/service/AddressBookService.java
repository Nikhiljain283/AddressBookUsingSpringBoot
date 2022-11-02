package com.addressBook.addressBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.model.AddressBookModel;
import com.addressBook.addressBook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService{
	
	@Autowired
	AddressBookRepository repo;

	public AddressBookModel addDataDb(AddressBookDTO data) {
		AddressBookModel response = new AddressBookModel(data);
		repo.save(response);
		return response;
	}

	public AddressBookModel getdetailById(int id) {
		return repo.findById(id).get();
	}

	
	public List<AddressBookModel> getDbDetail() {
		return repo.findAll();
	}

	
	public void deletedetailsById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public AddressBookModel updateDetailById(AddressBookDTO model, int id) {
		AddressBookModel existingData = repo.findById(id).get();
		existingData.setFullName(model.getFullName());
		AddressBookModel res = repo.save(existingData);
		return res;
	}

	

}
