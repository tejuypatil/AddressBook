package com.devlopment.addressbook.model;

import com.devlopment.addressbook.DTO.AddressDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    public String firstName;
    public String lastName;
    public int phoneNumber;
    public String email;

    @ElementCollection
    @CollectionTable(name = "addresses", joinColumns = @JoinColumn(name = "id"))
    public List<String> addresses;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int userId;



    public Contact(AddressDTO addressBookDTO) {

        this.firstName= addressBookDTO.firstName;
        this.lastName= addressBookDTO.lastName;
        this.addresses= addressBookDTO.addresses;
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

