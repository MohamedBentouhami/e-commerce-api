package com.example.e_commerce_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.e_commerce_api.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
