package com.example.ecommerce.catalog_service.infrastructure.persistence.repository;

import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
