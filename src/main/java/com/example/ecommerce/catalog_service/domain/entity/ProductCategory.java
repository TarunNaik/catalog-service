package com.example.ecommerce.catalog_service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategory {
    private UUID id;
    private String name;
    private String description;
    private String status = "ACTIVE";
}
