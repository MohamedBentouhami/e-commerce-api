package com.example.e_commerce_api.mappers;

import com.example.e_commerce_api.dtos.RegisterUserRequest;
import com.example.e_commerce_api.dtos.UpdateUserRequest;
import com.example.e_commerce_api.dtos.UserDto;
import com.example.e_commerce_api.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);
}
