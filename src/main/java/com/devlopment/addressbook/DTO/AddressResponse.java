package com.devlopment.addressbook.DTO;

import com.devlopment.addressbook.model.Contact;

public class AddressResponse {
    public String message;
    public Contact data;

    public AddressResponse(String message, Contact data) {
        this.message = message;
        this.data = data;
    }
}