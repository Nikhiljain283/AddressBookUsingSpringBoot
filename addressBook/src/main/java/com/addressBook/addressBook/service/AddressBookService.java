package com.addressBook.addressBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.exception.CustomException;
import com.addressBook.addressBook.model.AddressBookModel;
import com.addressBook.addressBook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	AddressBookRepository repo;

	public AddressBookModel addDataDb(AddressBookDTO contact) {
		AddressBookModel response = new AddressBookModel(contact);
		repo.save(response);
		return response;
	}

	public AddressBookModel getdetailById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new CustomException("Contact with " + id + " id is not found in the Address Book");
		}
	}

	public List<AddressBookModel> getDbDetail() {
		if (!repo.findAll().isEmpty()) {
			return repo.findAll();
		} else {
			throw new CustomException("Table is empty");
		}

	}

	public void deletedetailsById(int id) {
		repo.deleteById(id);

	}

	public AddressBookModel updateDetailById(AddressBookDTO model, int id) {
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
