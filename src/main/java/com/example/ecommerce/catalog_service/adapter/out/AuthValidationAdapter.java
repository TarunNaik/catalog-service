package com.example.ecommerce.catalog_service.adapter.out;

import com.example.ecommerce.catalog_service.adapter.out.dto.UserAuthorizeRequest;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import org.springframework.stereotype.Component;



@Component
public class AuthValidationAdapter implements AuthValidationPort {
    private final AuthFeignClient authFeignClient;
    public AuthValidationAdapter( AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Override
    public Boolean validateToken(String token, String requiredRole) {
        UserAuthorizeRequest request = new UserAuthorizeRequest(token, requiredRole);
       return authFeignClient.validateToken(request);
    }
}
