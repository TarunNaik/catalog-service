package com.example.ecommerce.catalog_service.domain.port.out;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryRepositoryPort {
  List<ProductCategory> findAllCategories();
}
