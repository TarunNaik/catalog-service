package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.in.SaveProductPort;
import org.springframework.stereotype.Service;

@Service
public class SaveProductUseCase implements SaveProductPort {
    @Override
    public Product saveProduct(ProductDto productDto) {
        // Implementation logic to save the product
        return null;
    }
}
