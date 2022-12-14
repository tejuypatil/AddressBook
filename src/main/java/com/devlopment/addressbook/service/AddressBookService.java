package com.devlopment.addressbook.service;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.exception.ContactNotFoundException;
import com.devlopment.addressbook.model.Contact;
import com.devlopment.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
        try {
            Optional<Contact> addressDataOptional = addressBookRepository.findById(id);
            Contact contact = addressDataOptional.get();
            return contact;

        }
        catch (NoSuchElementException exception)
        {
            throw new ContactNotFoundException(id);
        }

    }

    public Contact updateAddress(int id, AddressDTO addressDTO) {
        try {
            Optional<Contact> addressDataOptional = addressBookRepository.findById(id);
            Contact addressData = addressDataOptional.get();
            addressData.setFirstName(addressDTO.firstName);
            addressData.setLastName(addressDTO.lastName);
            addressBookRepository.save(addressData);
            return addressData;
        }
        catch (NoSuchElementException exception)
        {
            throw new ContactNotFoundException(id);
        }
    }
    public Contact deleteAddress(int id) {
        try {
            addressBookRepository.deleteById(id);
            return null;
        } catch (EmptyResultDataAccessException exception) {
            throw new ContactNotFoundException(id);
        }
    }

}


