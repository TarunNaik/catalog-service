package com.example.ecommerce.catalog_service.adapter.out.mapper;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "CategoryOutMapperImpl")
public interface CategoryMapper {
    ProductCategory toDomain(ProductCategoryEntity entity);

    ProductCategoryEntity toEntity(ProductCategory domain);
}
