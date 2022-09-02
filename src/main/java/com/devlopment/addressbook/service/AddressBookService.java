package com.devlopment.addressbook.service;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.model.AddressData;
import com.devlopment.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    public AddressData createAddress(AddressDTO addressDTO){
        AddressData addressData = new AddressData(addressDTO);
        return addressBookRepository.save(addressData);
    }
    public AddressData getAddress(int id){
        Optional<AddressData> addressDataOptional= addressBookRepository.findById(id);
        AddressData addressData = addressDataOptional.get();
        return addressData;
    }

    public AddressData updateAddress(int id,AddressDTO addressDTO){
        Optional<AddressData>addressDataOptional = addressBookRepository.findById(id);
        AddressData addressData =addressDataOptional.get();
        addressData.setFirstName(addressDTO.firstName);
        addressData.setLastName(addressDTO.lastName);
        addressBookRepository.save(addressData);
        return addressData;
    }

    public AddressData deleteAddress(int id){
        addressBookRepository.deleteById(id);
        return null;
    }

}


