package com.example.ecommerce.catalog_service.domain.port.in;

import java.util.UUID;

public interface DeleteProductPort {
    void deleteProduct(String token, UUID productId);
}
