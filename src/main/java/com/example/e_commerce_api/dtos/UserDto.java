package com.example.e_commerce_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    public Long id;
    public String name;
    public String email;
}
