package com.example.ecommerce.catalog_service.domain.port.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.CategoryDto;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FetchProductCategoriesPort {
   Mono<List<ProductCategory>> fetchAllCategories(String authToken) throws Exception;
}
