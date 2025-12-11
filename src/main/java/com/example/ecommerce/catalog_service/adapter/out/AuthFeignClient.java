package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.out.dto.UserAuthorizeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthFeignClient {
    @GetMapping("/validate-token")
    Boolean validateToken( @RequestHeader("Authorization") String token,
                           @RequestParam("role") String role);

    @GetMapping("/get-user-id")
    Optional<UUID> getUserIdFromToken(
            @RequestHeader("Authorization") String token,
            @RequestParam("role") String role);

}
