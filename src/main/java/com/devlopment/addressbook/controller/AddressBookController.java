package com.devlopment.addressbook.controller;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.DTO.AddressResponse;
import com.devlopment.addressbook.model.Contact;
import com.devlopment.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/addressbookservice")
    public ResponseEntity <AddressResponse> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        Contact addressData= addressBookService.createAddress(addressDTO);
        AddressResponse addressResponse = new AddressResponse("Create successful",addressData);
        ResponseEntity<AddressResponse> response = new ResponseEntity<>(addressResponse, HttpStatus.OK);
        return response;
    }
    @GetMapping("/addressbookservice/{id}")
    public ResponseEntity <AddressResponse> getAddress(@PathVariable ("id") int id){
        Contact addressData = addressBookService.getAddress(id);
        AddressResponse addressResponse = new AddressResponse("Get call Successes",addressData);
        ResponseEntity<AddressResponse> response = new ResponseEntity<>(addressResponse, HttpStatus.OK);
        return response;
    }
    @PutMapping("/addressbookservice/{id}")
    public ResponseEntity <AddressResponse> updateAddress(@PathVariable ("id") int id,@Valid@RequestBody AddressDTO addressDTO){
        Contact addressData = addressBookService.updateAddress(id, addressDTO);
        AddressResponse addressResponse = new AddressResponse("Updated Address",addressData);
        ResponseEntity<AddressResponse> response = new ResponseEntity<>(addressResponse, HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/addressbookservice/{id}")
    public ResponseEntity <AddressResponse> deleteAddress(@PathVariable ("id")int id)
    {
        Contact addressData = addressBookService.deleteAddress(id);
        AddressResponse addressResponse = new AddressResponse("Deleted Address",addressData);
        ResponseEntity<AddressResponse> response = new ResponseEntity<>(addressResponse, HttpStatus.OK);
        return response;
    }
}

