package com.example.ecommerce.catalog_service.domain.port.out;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepositoryPort {
  List<ProductCategory> findAllCategories();
  Optional<ProductCategory> findByName(String name);
}
