package com.devlopment.addressbook.model;

import com.devlopment.addressbook.DTO.AddressDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
    public String firstName;
    public String lastName;
    public int phoneNumber;
    public String email;
    public String address;
    @Id
    @GeneratedValue
    public int userId;

    public Contact(String firstName, String lastName, int phoneNumber, String email, String address, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.userId = userId;
    }

    public Contact(AddressDTO addressBookDTO) {

        this.firstName= addressBookDTO.firstName;
        this.lastName= addressBookDTO.lastName;
    }

    public Contact() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

