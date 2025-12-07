package com.example.ecommerce.catalog_service.adapter.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import com.example.ecommerce.catalog_service.domain.port.in.SaveProductPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final SaveProductPort saveProductPort;

    public ProductController(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @PostMapping
    public ResponseEntity<ProductDto>addProduct(@RequestHeader("Authorization") String token, @RequestBody ProductDto productDto) {
         createdProduct = saveProductPort.saveProduct(productDto);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(new ProductDto());
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(Collections.emptyList());
    }

}
