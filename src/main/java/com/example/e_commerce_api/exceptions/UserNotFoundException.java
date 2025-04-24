package com.example.e_commerce_api.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with ID " + id + " not found");
    }
}
