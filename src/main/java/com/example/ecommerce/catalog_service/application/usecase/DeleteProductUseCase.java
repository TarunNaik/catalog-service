package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.port.in.DeleteProductPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCase implements DeleteProductPort {
    @Override
    public void deleteProduct(Long productId) {
        // Implementation logic to delete the product
    }
}
