package com.example.e_commerce_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String email;
}
