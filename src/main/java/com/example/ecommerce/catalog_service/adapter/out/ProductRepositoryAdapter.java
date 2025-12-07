package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.out.mapper.ProductEntityMapper;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.out.ProductRepositoryPort;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import com.example.ecommerce.catalog_service.infrastructure.persistence.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper = ProductEntityMapper.INSTANCE;

    public ProductRepositoryAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productRepository.save(productEntityMapper.toEntity(product));
        return productEntityMapper.toDomain(productEntity);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.empty();
    }
}
