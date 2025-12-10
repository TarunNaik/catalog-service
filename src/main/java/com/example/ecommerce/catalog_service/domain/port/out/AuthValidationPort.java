package com.example.ecommerce.catalog_service.domain.port.out;

public interface AuthValidationPort {
    Boolean validateToken(String token, String requiredRole);

}
