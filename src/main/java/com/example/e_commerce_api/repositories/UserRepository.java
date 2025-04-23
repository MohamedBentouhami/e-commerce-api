package com.example.e_commerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.e_commerce_api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
