package com.example.ecommerce.catalog_service.adapter.in.mapper;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductMapper.class);

    // --- Entity to DTO ---
    @Mapping(source = "price.amount", target = "price")
    @Mapping(source = "stock.quantity", target = "stockQuantity")
    @Mapping(source = "categoryId", target = "category")
    ProductDto toDto(Product product);

    @Mapping(source = "price", target = "price.amount")
    @Mapping(source = "stockQuantity", target = "stock.quantity")
    @Mapping(source = "category", target = "categoryId")
    Product toDomain(ProductDto dto);

}
