package com.example.e_commerce_api.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product with id :" + id + " not found");
    }
}
