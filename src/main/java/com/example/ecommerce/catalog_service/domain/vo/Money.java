package com.example.ecommerce.catalog_service.domain.vo;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {

    public Money {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Money requires amount and currency");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money amount cannot be negative");
        }

    }

    public Money add(Money other) {
        validateSameCurrency(other);
        return new Money(this.amount.add(other.amount), this.currency);
    }
    public Money subtract(Money other) {
        validateSameCurrency(other);
        BigDecimal result = this.amount.subtract(other.amount);
        if (result.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }
        return new Money(result, this.currency);
    }

    private void validateSameCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
    }

    public void changePrice(Money newPrice) {
        if (!this.currency.equals(newPrice.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        if (newPrice.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be zero or negative");
        }
        if(newPrice.amount.equals(this.amount)) {
            throw new IllegalArgumentException("New price must be different from the current price");
        }
        BigDecimal difference = newPrice.amount.subtract(this.amount);
        if(difference.compareTo(BigDecimal.ZERO) < 0) {
           subtract(new Money(difference.abs(), this.currency));
        }
        else {
            add(new Money(difference, this.currency));
        }

    }
}
