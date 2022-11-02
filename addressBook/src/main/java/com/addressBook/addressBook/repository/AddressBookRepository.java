package com.addressBook.addressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addressBook.addressBook.model.AddressBookModel;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

}
