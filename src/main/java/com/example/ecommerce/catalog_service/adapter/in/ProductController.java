package com.example.ecommerce.catalog_service.adapter.in;

import com.example.ecommerce.catalog_service.adapter.in.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @PostMapping
    public ProductDto saveProduct(@RequestHeader("Authorization") String token, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productDto).getBody();
    }

}
