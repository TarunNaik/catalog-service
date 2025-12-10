package com.example.ecommerce.catalog_service.infrastructure.persistence.mapper;

import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.vo.Money;
import com.example.ecommerce.catalog_service.domain.vo.Stock;
import com.example.ecommerce.catalog_service.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Currency;

@Mapper(componentModel = "spring", uses = {ProductCategoryEntityMapper.class})
public interface ProductEntityMapper {


    // --- Domain → Entity ---
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price.amount", target = "price")
    @Mapping(source = "price.currency", target = "currency")
    @Mapping(source = "stock.quantity", target = "stockQuantity")
    @Mapping(source = "imgUrl", target = "imageUrl")
    @Mapping(source = "category", target = "category") // handled by ProductCategoryEntityMapper
    ProductEntity toEntity(Product product);

    // --- Entity → Domain ---
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price.amount")
    @Mapping(source = "currency", target = "price.currency")
    @Mapping(source = "stockQuantity", target = "stock.quantity")
    @Mapping(source = "imageUrl", target = "imgUrl")
    @Mapping(source = "category", target = "category") // handled by ProductCategoryEntityMapper
    Product toDomain(ProductEntity entity);

    // --- Money ↔ BigDecimal + Currency ---
    default Money map(BigDecimal amount, String currencyCode) {
        if (amount == null || currencyCode == null) return null;
        return new Money(amount, Currency.getInstance(currencyCode));
    }

    default BigDecimal map(Money money) {
        return money == null ? null : money.amount();
    }

    default String mapCurrency(Money money) {
        return money == null ? null : money.currency().getCurrencyCode();
    }

    // --- Stock ↔ int ---
    default Stock map(int quantity) {
        return new Stock(quantity);
    }

    default int map(Stock stock) {
        return stock == null ? 0 : stock.quantity();
    }

}
