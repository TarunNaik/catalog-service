package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.out.mapper.CategoryMapper;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import com.example.ecommerce.catalog_service.infrastructure.persistence.repository.ProductCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Component
public class ProductCategoryRepositoryAdapter implements ProductCategoryRepositoryPort {

    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryMapper categoryMapper;

    public ProductCategoryRepositoryAdapter(ProductCategoryRepository productCategoryRepository, CategoryMapper categoryMapper) {
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
}
