package com.devlopment.addressbook.DTO;

import com.devlopment.addressbook.model.Contact;

public class ExceptionResponse {
    public String message;
    public Object errorObj;

    public ExceptionResponse(String message, Object errorObj) {
        this.message = message;
        this.errorObj = errorObj;
    }
}
