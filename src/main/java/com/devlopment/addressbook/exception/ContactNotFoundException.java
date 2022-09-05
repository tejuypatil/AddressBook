package com.devlopment.addressbook.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(int id)
    {
        super("Contact not found with id = " + id);
    }
}
