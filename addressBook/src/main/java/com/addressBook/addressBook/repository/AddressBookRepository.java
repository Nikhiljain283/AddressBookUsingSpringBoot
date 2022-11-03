package com.addressBook.addressBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.addressBook.addressBook.model.AddressBookModel;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

	@Query(value = "select * from address_book__model, contact_state where state = state", nativeQuery = true)
	List<AddressBookModel> findByState(String state);
}
