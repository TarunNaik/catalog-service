package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.in.mapper.CategoryMapper;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import com.example.ecommerce.catalog_service.infrastructure.persistence.mapper.ProductCategoryEntityMapper;
import com.example.ecommerce.catalog_service.infrastructure.persistence.repository.ProductCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductCategoryRepositoryAdapter implements ProductCategoryRepositoryPort {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryEntityMapper categoryMapper;

    public ProductCategoryRepositoryAdapter(ProductCategoryRepository productCategoryRepository, ProductCategoryEntityMapper categoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<ProductCategory> findAllCategories() {
        //Retrieve all product categories from the database and return their names and ids
        return productCategoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<ProductCategory> findByName(String name) {
        return productCategoryRepository.findByName(name).map(categoryMapper::toDomain);

    }
}
