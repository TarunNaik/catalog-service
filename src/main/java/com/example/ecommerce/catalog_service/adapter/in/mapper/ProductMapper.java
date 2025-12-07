package com.example.ecommerce.catalog_service.adapter.in.mapper;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.vo.Money;
import com.example.ecommerce.catalog_service.domain.vo.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductMapper.class);

    // --- Domain → DTO ---
    @Mapping(source = "id", target = "id")
    @Mapping(source = "price.amount", target = "price")
    @Mapping(source = "imgUrl", target = "imageUrl")
    @Mapping(source = "stock.quantity", target = "stockQuantity")
    @Mapping(source = "category", target = "category") // handled by custom method
    ProductDto toDto(Product product);

    // --- DTO → Domain ---
    @Mapping(source = "id", target = "id")
    @Mapping(source = "price", target = "price")       // handled by custom method
    @Mapping(source = "imageUrl", target = "imgUrl")
    @Mapping(source = "stockQuantity", target = "stock") // handled by custom method
    @Mapping(source = "category", target = "category")   // handled by custom method
    Product toDomain(ProductDto dto);

    // --- Custom conversions ---

    // ProductCategory ↔ String
    default String map(ProductCategory category) {
        return category == null ? null : category.getId().toString();
    }

    default ProductCategory map(String categoryId) {
        if (categoryId == null) return null;
        return new ProductCategory(UUID.fromString(categoryId), null, null, "ACTIVE");
        // You can enrich name/description/status later by fetching from master data
    }

    // Money ↔ BigDecimal
    default BigDecimal map(Money money) {
        return money == null ? null : money.amount();
    }

    default Money map(BigDecimal amount) {
        return amount == null ? null : new Money(amount, Currency.getInstance("INR"));
    }

    // Stock ↔ int
    default int map(Stock stock) {
        return stock == null ? 0 : stock.quantity();
    }

    default Stock map(int quantity) {
        return new Stock(quantity);
    }


}
