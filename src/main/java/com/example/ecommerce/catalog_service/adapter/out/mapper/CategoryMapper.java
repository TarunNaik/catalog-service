package com.example.ecommerce.catalog_service.adapter.out.mapper;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(CategoryMapper.class);

    ProductCategory toDomain(ProductCategoryEntity entity);

    ProductCategoryEntity toEntity(ProductCategory domain);
}
