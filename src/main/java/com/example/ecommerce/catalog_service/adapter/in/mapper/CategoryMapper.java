package com.example.ecommerce.catalog_service.adapter.in.mapper;

import com.example.ecommerce.catalog_service.adapter.in.dto.CategoryDto;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;

@Mapper(componentModel = "spring", implementationName = "CategoryInMapperImpl")
public interface CategoryMapper {

    CategoryDto toDto(ProductCategory domain);

    ProductCategory toDomain(CategoryDto dto);


}
