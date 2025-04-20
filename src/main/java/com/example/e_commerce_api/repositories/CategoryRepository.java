package com.example.e_commerce_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.e_commerce_api.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
