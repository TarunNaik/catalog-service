package com.example.ecommerce.catalog_service.adapter.out.mapper;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductEntityMapper.class);

    Product toDomain(ProductEntity entity);

    ProductEntity toEntity(Product product);
}
