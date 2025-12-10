package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.in.ListProductsPort;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsUseCase implements ListProductsPort {

    private final AuthValidationPort authValidationPort;
    private final ProductRepositoryPort productRepositoryPort;

    public ListProductsUseCase(AuthValidationPort authValidationPort, ProductRepositoryPort productRepositoryPort) {
        this.authValidationPort = authValidationPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> listAllProducts(String jwtToken) {
        //Check if the user is authorized to save a product
        Boolean valid = authValidationPort.validateToken(jwtToken, "VENDOR");
        return productRepositoryPort.fetchAllProducts();
    }
}
