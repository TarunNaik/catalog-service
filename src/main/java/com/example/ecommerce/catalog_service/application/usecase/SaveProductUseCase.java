package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.adapter.in.mapper.ProductMapper;
import com.example.ecommerce.catalog_service.application.exception.UnauthorizedAccessException;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.in.SaveProductPort;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductRepositoryPort;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import com.example.ecommerce.catalog_service.infrastructure.persistence.mapper.ProductEntityMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SaveProductUseCase implements SaveProductPort {

    private final AuthValidationPort authValidationPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final ProductCategoryRepositoryPort productCategoryRepositoryPort;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final ProductEntityMapper productEntityMapper;

    public SaveProductUseCase(AuthValidationPort authValidationPort, ProductRepositoryPort productRepositoryPort, ProductCategoryRepositoryPort productCategoryRepositoryPort, ProductEntityMapper productEntityMapper) {
        this.authValidationPort = authValidationPort;
        this.productRepositoryPort = productRepositoryPort;
        this.productCategoryRepositoryPort = productCategoryRepositoryPort;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product saveProduct(ProductDto productDto, String jwtToken) {
        //Check if the user is authorized to save a product
        Optional<UUID> vendorId = authValidationPort.getUserIdFromToken(jwtToken, "VENDOR");
        if (vendorId.isEmpty()) {
            throw new UnauthorizedAccessException("User is not authorized to perform this action");
        }
        Product product = productMapper.toDomain(productDto);

        ProductCategory category = productCategoryRepositoryPort.findByName(productDto.getCategory())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        product.setCategory(category);
        product.setVendorId(vendorId.get());
        return productRepositoryPort.save(product);
    }
}
