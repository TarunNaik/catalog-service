package com.example.ecommerce.catalog_service.domain.port.out;

import com.example.ecommerce.catalog_service.domain.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> fetchAllProducts(UUID vendorId);

}
