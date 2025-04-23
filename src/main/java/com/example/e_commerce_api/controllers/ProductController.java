package com.example.e_commerce_api.controllers;

import com.example.e_commerce_api.dtos.ProductDto;
import com.example.e_commerce_api.mappers.ProductMapper;
import com.example.e_commerce_api.models.Product;
import com.example.e_commerce_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/")
    public Iterable<ProductDto> getAllProducts(@RequestParam(required = false) Long categoryId) {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}
