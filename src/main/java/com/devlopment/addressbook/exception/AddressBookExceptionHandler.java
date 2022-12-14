package com.devlopment.addressbook.exception;

import com.devlopment.addressbook.DTO.AddressDTO;
import com.devlopment.addressbook.DTO.AddressResponse;
import com.devlopment.addressbook.DTO.ExceptionResponse;
import org.springframework.http.HttpStatus;
;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class AddressBookExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());

        ExceptionResponse exceptionResponse = new ExceptionResponse("MethodArgumentNotValidException", errMsg);
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleContactNotFoundException(ContactNotFoundException exception)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse("ContactNotFound", exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
