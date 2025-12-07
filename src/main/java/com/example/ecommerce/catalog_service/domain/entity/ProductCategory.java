package com.example.ecommerce.catalog_service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategory {
    private Long id;
    private String name;
    private String description;
    private String status = "ACTIVE";
}
