package com.devlopment.addressbook.repository;

import com.devlopment.addressbook.model.AddressData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressData,Integer>{

}

