package com.authservice.system.client.controllers;

import com.authservice.system.client.dtos.AddToCartRequest;
import com.authservice.system.client.dtos.CartItemsDto;
import com.authservice.system.client.dtos.CartResponseDto;
import com.authservice.system.client.dtos.UpdateCartItemRequest;
import com.authservice.system.client.services.AuthCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth/carts")
@RequiredArgsConstructor
public class AuthCartController {

    private final AuthCartService authCartService;

    @PostMapping
    public ResponseEntity<CartResponseDto> createCart() {
        var response = authCartService.createCart();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{cartId}")
    public CartResponseDto getCartDetails(@PathVariable String cartId) {
        return authCartService.getCartDetails(cartId);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<?> addToCart(@PathVariable String cartId,
                                       @RequestBody AddToCartRequest request) {
        CartItemsDto response = authCartService.addToCart(cartId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{cartId}/items/{productId}")
    public ResponseEntity<CartItemsDto> updateCartItem(@PathVariable String cartId,
                                                       @PathVariable String productId,
                                                       @RequestBody UpdateCartItemRequest request) {
        CartItemsDto response = authCartService.updateCartItem(cartId, productId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable String cartId,
                                               @PathVariable String productId) {
        authCartService.deleteCartItem(cartId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable String cartId) {
        authCartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }
}

