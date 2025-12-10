package com.example.ecommerce.catalog_service.domain.port.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.entity.Product;

public interface SaveProductPort {
    Product saveProduct(ProductDto productDto, String jwtToken);
}
