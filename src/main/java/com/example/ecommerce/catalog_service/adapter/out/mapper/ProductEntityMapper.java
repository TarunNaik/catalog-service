package com.example.ecommerce.catalog_service.adapter.out.mapper;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.vo.Money;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductCategoryEntity;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.Currency;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductEntityMapper.class);

    Product toDomain(ProductEntity entity);

    ProductEntity toEntity(Product product);

    // --- Custom conversions ---

    // Money ↔ BigDecimal
    default BigDecimal map(Money money) {
        return money == null ? null : money.amount();
    }

    default Money map(BigDecimal amount, Currency currency) {
        return amount == null ? null : new Money(amount, currency);
    }

    // Category ↔ ProductCategoryEntity
    default ProductCategoryEntity map(ProductCategory category) {
        if (category == null) return null;
        ProductCategoryEntity entity = new ProductCategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setStatus(category.getStatus());
        return entity;
    }

    default ProductCategory map(ProductCategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProductCategory(entity.getId(), entity.getName(), entity.getDescription(), entity.getStatus());
    }

}
