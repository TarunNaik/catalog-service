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
    @Mapping(source = "price.currency", target = "currency") // handled by custom method
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "stock.quantity", target = "stock")
    @Mapping(source = "category", target = "category") // handled by custom method
    ProductDto toDto(Product product);

    // --- DTO → Domain ---
    @Mapping(source = "price", target = "price.amount")
    @Mapping(source = "currency", target = "price.currency")// handled by custom method
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "stock", target = "stock.quantity") // handled by custom method
    @Mapping(source = "category", target = "category")   // handled by custom method
    Product toDomain(ProductDto dto);

    // --- Custom conversions ---

    // ProductCategory ↔ String
    default String map(ProductCategory category) {
        return category == null ? null : category.getName();
    }

    default ProductCategory map(String categoryName) {
        if (categoryName == null) return null;
        return new ProductCategory(null, categoryName, null, "ACTIVE");
    }


    // Money ↔ BigDecimal
    default BigDecimal map(Money money) {
        return money == null ? null : money.amount();
    }

    default Money map(BigDecimal price, String currencyCode) {
        if (price == null || currencyCode == null) {
            return null;
        }
        return new Money(price, Currency.getInstance(currencyCode));
    }


    // Stock ↔ int
    default int map(Stock stock) {
        return stock == null ? 0 : stock.quantity();
    }

    default Stock map(int quantity) {
        return new Stock(quantity);
    }


}
