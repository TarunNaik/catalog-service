package com.example.ecommerce.catalog_service.domain.entity;


import com.example.ecommerce.catalog_service.domain.vo.Money;
import com.example.ecommerce.catalog_service.domain.vo.Stock;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private UUID id;
    private String name;
    private String description;
    private Money price;
    private Stock stock;
    private String imgUrl;
    private ProductCategory category;

    // Business operations
    public void changePrice(Money newPrice) {
        this.price.changePrice(newPrice);

    }

    public void reduceStock(int quantity) {
        this.stock = this.stock.decrease(quantity);
    }

    public void increaseStock(int quantity) {
        this.stock = this.stock.increase(quantity);
    }

    public boolean isAvailable(int quantity) {
        return this.stock.isAvailable(quantity);
    }


}
