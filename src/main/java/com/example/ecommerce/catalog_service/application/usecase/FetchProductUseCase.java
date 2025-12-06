package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.port.in.FetchProductPort;
import org.springframework.stereotype.Service;

@Service
public class FetchProductUseCase implements FetchProductPort {
    @Override
    public ProductDto fetchProduct(Long productId) {
        // Implementation goes here
        return null;
    }
}
