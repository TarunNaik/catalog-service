package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.in.FetchProductCategoriesPort;
import com.example.ecommerce.catalog_service.domain.port.out.AuthValidationPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import org.springframework.stereotype.Service;


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
    public List<ProductCategory> fetchAllCategories(String authToken) throws Exception {
        return productCategoryRepositoryPort.findAllCategories();
    }
}
