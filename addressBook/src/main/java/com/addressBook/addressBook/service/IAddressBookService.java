package com.addressBook.addressBook.service;

import java.util.List;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.model.AddressBookModel;

public interface IAddressBookService {

	AddressBookModel addDataDb(AddressBookDTO data);

	AddressBookModel getdetailById(int id);

	List<AddressBookModel> getDbDetail();

	void deletedetailsById(int id);

	AddressBookModel updateDetailById(AddressBookDTO data, int id);

}
