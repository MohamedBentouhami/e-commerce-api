package com.example.e_commerce_api.controllers;

import com.example.e_commerce_api.dtos.UserDto;
import com.example.e_commerce_api.mappers.UserMapper;
import com.example.e_commerce_api.models.User;
import com.example.e_commerce_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public Iterable<UserDto> getAllUsers
            (@RequestParam(required = false, defaultValue = "", name = "sort") String sort) {

        if (!Set.of("name", "email").contains(sort)) sort = "name";
        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
