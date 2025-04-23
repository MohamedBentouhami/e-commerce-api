package com.example.e_commerce_api.dtos;

import com.example.e_commerce_api.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDto {
   private Long id;
   private String name;
   private String description;
   private BigDecimal price;
   private Long categoryId;
}
