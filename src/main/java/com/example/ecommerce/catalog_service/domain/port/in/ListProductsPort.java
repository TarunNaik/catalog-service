package com.example.ecommerce.catalog_service.domain.port.in;

import com.example.ecommerce.catalog_service.domain.entity.Product;

import java.util.List;

public interface ListProductsPort {
    List<Product> listAllProducts(String jwtToken);
}
