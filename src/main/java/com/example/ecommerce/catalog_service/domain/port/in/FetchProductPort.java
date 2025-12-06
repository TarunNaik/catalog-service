package com.example.ecommerce.catalog_service.domain.port.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;

public interface FetchProductPort {
    ProductDto fetchProduct(Long productId);
}
