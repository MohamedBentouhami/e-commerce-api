package com.example.e_commerce_api.mappers;

import com.example.e_commerce_api.dtos.UserDto;
import com.example.e_commerce_api.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
