package com.example.ecommerce.catalog_service.domain.port.out;

import reactor.core.publisher.Mono;

public interface AuthValidationPort {
    Mono<Boolean> validateToken(String token, String requiredRole);

}
