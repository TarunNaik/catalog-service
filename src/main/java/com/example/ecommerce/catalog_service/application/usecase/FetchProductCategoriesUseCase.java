package com.example.ecommerce.catalog_service.application.usecase;

import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.in.FetchProductCategoriesPort;
import com.example.ecommerce.catalog_service.domain.port.out.ProductCategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchProductCategoriesUseCase implements FetchProductCategoriesPort {

    private final ProductCategoryRepositoryPort productCategoryRepositoryPort;

    public FetchProductCategoriesUseCase(ProductCategoryRepositoryPort productCategoryRepositoryPort) {
        this.productCategoryRepositoryPort = productCategoryRepositoryPort;
    }

    @Override
    public List<ProductCategory> fetchAllCategories(String authToken) {
        //Check if authToken is valid (implementation omitted for brevity)
        // Implementation logic to fetch all product categories
        return productCategoryRepositoryPort.findAllCategories();
    }
}
