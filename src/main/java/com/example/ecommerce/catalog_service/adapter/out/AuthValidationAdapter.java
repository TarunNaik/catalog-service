package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.out.dto.UserAuthorizeRequest;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthValidationAdapter implements AuthValidationPort {
    private final WebClient webClient;
    public AuthValidationAdapter(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080/api/v1/auth").build();
    }

    @Override
    public Mono<Boolean> validateToken(String token, String requiredRole) {
        UserAuthorizeRequest request = new UserAuthorizeRequest(token, requiredRole);
       return webClient.post()
                .uri("/validate-token")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}
