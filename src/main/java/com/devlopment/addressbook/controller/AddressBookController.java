package com.devlopment.addressbook.controller;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.DTO.AddressResponse;
import com.devlopment.addressbook.model.AddressData;
import com.devlopment.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/addressbookservice")
    public AddressResponse createAddress(@RequestBody AddressDTO addressDTO){
        AddressData addressData= addressBookService.createAddress(addressDTO);
        AddressResponse addressResponse = new AddressResponse("Create successful",addressData);
        return addressResponse;
    }
    @GetMapping("/addressbookservice/{id}")
    public AddressResponse getAddress(@PathVariable ("id") int id){
        AddressData addressData = addressBookService.getAddress(id);
        AddressResponse addressResponse = new AddressResponse("Get call Successes",addressData);
        return addressResponse;
    }



}

