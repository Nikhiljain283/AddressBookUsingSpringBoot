package com.addressBook.addressBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.addressBook.addressBook.model.AddressBookModel;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

	@Query(value = "select * from new_database.address_book_model, new_database.contact_state where address_book_model.id = contact_state.id and state = :state", nativeQuery = true)
	List<AddressBookModel> findByState(String state);
}
