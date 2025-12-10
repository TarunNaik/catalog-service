package com.example.ecommerce.catalog_service.application.exception;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
      super(message);
    }
}
