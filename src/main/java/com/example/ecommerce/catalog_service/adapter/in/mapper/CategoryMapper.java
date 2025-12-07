package com.example.ecommerce.catalog_service.adapter.in.mapper;

import com.example.ecommerce.catalog_service.adapter.in.dto.CategoryDto;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(ProductCategory domain);

    ProductCategory toDomain(CategoryDto dto);


}
