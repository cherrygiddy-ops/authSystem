package com.authservice.system.client.controllers;


import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.ProductsRequestDto;
import com.authservice.system.client.dtos.ProductsResponseDto;
import com.authservice.system.client.dtos.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/products")
public class AuthProductsController {

    private final OrderServiceClient orderServiceClient;

    @PostMapping
    public ResponseEntity<ProductsResponseDto> addProduct(@RequestBody ProductsRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceClient.addProduct(request));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductsResponseDto> getProductDetails(@PathVariable Integer productId) {
        return ResponseEntity.ok(orderServiceClient.getProductDetails(productId));
    }

    // ✅ Unified GET endpoint with category, keyword, and sort filters
    @GetMapping
    public ResponseEntity<List<ProductsResponseDto>> getProducts(
            @RequestParam(required = false) Byte categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(orderServiceClient.getProducts(categoryId, keyword, sortBy));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        orderServiceClient.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductsResponseDto> updateProduct(
            @PathVariable Integer productId,
            @RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(orderServiceClient.updateProduct(productId, request));
    }
}
