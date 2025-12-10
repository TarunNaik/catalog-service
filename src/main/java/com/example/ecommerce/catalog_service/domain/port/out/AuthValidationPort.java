package com.example.ecommerce.catalog_service.domain.port.out;

import java.util.Optional;
import java.util.UUID;

public interface AuthValidationPort {
    Boolean validateToken(String token, String requiredRole);
    Optional<UUID> getUserIdFromToken(String token, String requiredRole);

}
