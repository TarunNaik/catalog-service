package com.example.ecommerce.catalog_service.adapter.out.dto;

public record UserAuthorizeRequest(String token, String requiredRole) {
}
