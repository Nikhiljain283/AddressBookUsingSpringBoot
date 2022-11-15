package com.addressBook.addressBook.service;

import java.util.List;

import com.addressBook.addressBook.DTO.AddressBookDTO;
import com.addressBook.addressBook.model.AddressBookModel;

public interface IAddressBookService {

	String addDataDb(AddressBookDTO contact);

	AddressBookModel getdetailById(String token);

	List<AddressBookModel> getDbDetail(String token);

	Integer deletedetailsById(String token);

	AddressBookModel updateDetailById(AddressBookDTO data, String token);

	List<AddressBookModel> getContactByState(String state);
}
