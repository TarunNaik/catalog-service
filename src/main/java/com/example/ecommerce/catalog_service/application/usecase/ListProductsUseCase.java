package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.in.ListProductsPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsUseCase implements ListProductsPort {

    @Override
    public List<Product> listAllProducts() {
        // Implementation goes here
        return null;
    }
}
