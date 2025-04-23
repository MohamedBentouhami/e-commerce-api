package com.example.e_commerce_api.mappers;

import com.example.e_commerce_api.dtos.ProductDto;
import com.example.e_commerce_api.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);
}
