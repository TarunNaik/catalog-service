package com.example.ecommerce.catalog_service.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
    private int stockQuantity;

}
