package com.example.ecommerce.catalog_service.infrastructure.utils;

public class AuthUtil {

    public static String extractToken(String authToken) {
        if (authToken != null && authToken.startsWith("Bearer ")) {
            return authToken.substring(7);
        }
        return null;
    }

}
