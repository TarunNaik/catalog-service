package com.example.ecommerce.catalog_service.domain.vo;

public record Stock(int quantity) {

    public Stock {
        if (quantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
    }
    public Stock increase(int quantity) {
        if( quantity <= 0) {
            throw new IllegalArgumentException("Increase amount cannot be less than or equal to zero");
        }
        return new Stock(this.quantity + quantity);
    }

    public Stock decrease(int quantity) {
        if( quantity <= 0) {
            throw new IllegalArgumentException("Decrease amount cannot be less than or equal to zero");
        }
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("Insufficient stock to decrease by the specified amount");
        }
        return new Stock(this.quantity - quantity);
    }

    public boolean isAvailable(int quantity) {
        return this.quantity >= quantity;
    }
}
