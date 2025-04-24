package com.example.e_commerce_api.controllers;

import com.example.e_commerce_api.dtos.RegisterUserRequest;
import com.example.e_commerce_api.dtos.UpdateUserRequest;
import com.example.e_commerce_api.dtos.UserDto;
import com.example.e_commerce_api.mappers.UserMapper;
import com.example.e_commerce_api.models.User;
import com.example.e_commerce_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public Iterable<UserDto> getAllUsers(
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort) {

        if (!Set.of("name", "email").contains(sort)) sort = "name";
        return userRepository.findAll(Sort.by(sort)).stream().map(userMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody RegisterUserRequest request,
                                              UriComponentsBuilder uriBuilder) {
        var user = userMapper.toEntity(request);
        userRepository.save(user);
        var uri = uriBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(userMapper.toDto(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateUserRequest request
    ) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        userMapper.update(request, user);
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();

        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
