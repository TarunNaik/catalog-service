package com.example.ecommerce.catalog_service.adapter.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.CategoryDto;
import com.example.ecommerce.catalog_service.adapter.in.mapper.CategoryMapper;
import com.example.ecommerce.catalog_service.domain.entity.ProductCategory;
import com.example.ecommerce.catalog_service.domain.port.in.FetchProductCategoriesPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/master-data")
public class MasterDataController {

    private final FetchProductCategoriesPort fetchProductCategoriesPort;
    private final CategoryMapper categoryMapper;

    public MasterDataController(FetchProductCategoriesPort fetchProductCategoriesPort, CategoryMapper categoryMapper) {
        this.fetchProductCategoriesPort = fetchProductCategoriesPort;
        this.categoryMapper = categoryMapper;
    }

    //Add Category, Brand, etc. endpoints here
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories(@RequestHeader("Authorization") String token) {
        List<ProductCategory> categories = fetchProductCategoriesPort.fetchAllCategories(token);
        return ResponseEntity.ok(categories.stream()
                .map(categoryMapper::toDto)
                .toList());
    }
}
