package com.example.e_commerce_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.e_commerce_api.models.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
