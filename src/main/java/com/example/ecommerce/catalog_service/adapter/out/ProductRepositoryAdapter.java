package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.out.ProductRepositoryPort;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import com.example.ecommerce.catalog_service.infrastructure.persistence.mapper.ProductCategoryEntityMapper;
import com.example.ecommerce.catalog_service.infrastructure.persistence.mapper.ProductEntityMapper;
import com.example.ecommerce.catalog_service.infrastructure.persistence.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;
    private final ProductCategoryEntityMapper categoryMapper;

    public ProductRepositoryAdapter(ProductRepository productRepository, ProductEntityMapper productEntityMapper, ProductCategoryEntityMapper categoryMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
        this.categoryMapper = categoryMapper;
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

    @Override
    public List<Product> fetchAllProducts(UUID vendorId) {
        return productRepository.findByVendorId(vendorId)
                .stream()
                .map(productEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }
}
