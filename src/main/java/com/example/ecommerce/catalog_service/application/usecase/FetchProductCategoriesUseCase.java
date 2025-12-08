package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.in.FetchProductCategoriesPort;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class FetchProductCategoriesUseCase implements FetchProductCategoriesPort {

    private final ProductCategoryRepositoryPort productCategoryRepositoryPort;
    private final AuthValidationPort authValidationPort;

    public FetchProductCategoriesUseCase(ProductCategoryRepositoryPort productCategoryRepositoryPort, AuthValidationPort authValidationPort) {
        this.productCategoryRepositoryPort = productCategoryRepositoryPort;
        this.authValidationPort = authValidationPort;
    }

    @Override
    public Mono<List<ProductCategory>> fetchAllCategories(String authToken) throws Exception {
        return authValidationPort.validateToken(authToken, "VENDOR")
                .flatMap(valid -> {
                    if (!valid) {
                        return Mono.error(new Exception("Unauthorized access"));
                    }
                    // Wrap synchronous repo call in boundedElastic if it's blocking
                    return Mono.fromCallable(productCategoryRepositoryPort::findAllCategories)
                            .subscribeOn(Schedulers.boundedElastic());
                });

    }
}
