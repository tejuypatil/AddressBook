package com.devlopment.addressbook.service;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.model.AddressData;
import com.devlopment.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    public AddressData createAddress(AddressDTO addressDTO){
        AddressData addressData = new AddressData(addressDTO);
        addressBookRepository.save(addressData);
        return addressData;
    }


}


