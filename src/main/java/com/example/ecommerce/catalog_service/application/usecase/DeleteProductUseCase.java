package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.port.in.DeleteProductPort;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductUseCase implements DeleteProductPort {
    private final AuthValidationPort authValidationPort;
    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCase(AuthValidationPort authValidationPort, ProductRepositoryPort productRepositoryPort) {
        this.authValidationPort = authValidationPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void deleteProduct( String jwtToken,UUID productId) {
        // Check if the user is authorized to delete a product
        Boolean isAuthorized = authValidationPort.validateToken(jwtToken, "VENDOR");
        // Implementation logic to delete the product
        productRepositoryPort.deleteProductById(productId);
    }
}
