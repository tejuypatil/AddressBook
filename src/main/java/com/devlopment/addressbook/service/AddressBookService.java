package com.devlopment.addressbook.service;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.model.Contact;
import com.devlopment.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    public Contact createAddress(AddressDTO addressDTO){
        Contact addressData = new Contact(addressDTO);
        return addressBookRepository.save(addressData);
    }
    public Contact getAddress(int id){
        Optional<Contact> addressDataOptional= addressBookRepository.findById(id);
        Contact addressData = addressDataOptional.get();
        return addressData;
    }

    public Contact updateAddress(int id, AddressDTO addressDTO){
        Optional<Contact>addressDataOptional = addressBookRepository.findById(id);
        Contact addressData =addressDataOptional.get();
        addressData.setFirstName(addressDTO.firstName);
        addressData.setLastName(addressDTO.lastName);
        addressBookRepository.save(addressData);
        return addressData;
    }

    public Contact deleteAddress(int id){
        addressBookRepository.deleteById(id);
        return null;
    }

}


