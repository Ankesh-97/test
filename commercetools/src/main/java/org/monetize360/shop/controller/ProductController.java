package org.monetize360.shop.controller;

import lombok.RequiredArgsConstructor;
import org.monetize360.shop.service.CommercetoolsApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final CommercetoolsApiService apiService;

    @GetMapping
    public ResponseEntity<String> getProducts() {
        // Example: Get products from Commercetools
        return apiService.get("/products", String.class);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody String productRequest) {
        // Example: Create a product in Commercetools
        return apiService.post("/products", productRequest, String.class);
    }
} 