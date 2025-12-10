package com.example.ecommerce.catalog_service.adapter.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.adapter.in.mapper.ProductMapper;
import com.example.ecommerce.catalog_service.application.exception.UnauthorizedAccessException;
import com.example.ecommerce.catalog_service.domain.entity.Product;
import com.example.ecommerce.catalog_service.domain.port.in.ListProductsPort;
import com.example.ecommerce.catalog_service.domain.port.in.SaveProductPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final SaveProductPort saveProductPort;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final ListProductsPort listProductsPort;

    public ProductController(SaveProductPort saveProductPort, ListProductsPort listProductsPort) {
        this.saveProductPort = saveProductPort;
        this.listProductsPort = listProductsPort;
    }

    @PostMapping("/add")
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ProductDto>addProduct(@RequestHeader("Authorization") String token, @RequestBody ProductDto productDto) {
       Product createdProduct = saveProductPort.saveProduct(productDto, token);
        return ResponseEntity.ok(productMapper.toDto(createdProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(new ProductDto());
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> listProducts(@RequestHeader("Authorization") String token) {
        List<Product> products = listProductsPort.listAllProducts(token);
        return ResponseEntity.ok(products.stream()
                .map(productMapper::toDto)
                .toList());
    }

}
