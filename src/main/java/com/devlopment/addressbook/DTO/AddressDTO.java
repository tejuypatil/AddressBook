package com.devlopment.addressbook.DTO;

import javax.validation.constraints.Pattern;

public class AddressDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public  String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Last name Invalid")
    public String lastName;

    public AddressDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}