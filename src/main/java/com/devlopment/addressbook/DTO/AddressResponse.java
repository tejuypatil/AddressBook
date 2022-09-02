package com.devlopment.addressbook.DTO;

import com.devlopment.addressbook.model.AddressData;

public class AddressResponse {
    public String message;
    public AddressData data;

    public AddressResponse(String message, AddressData data) {
        this.message = message;
        this.data = data;
    }
}