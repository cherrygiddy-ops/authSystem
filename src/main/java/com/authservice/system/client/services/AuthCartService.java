package com.authservice.system.client.services;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.AddToCartRequest;
import com.authservice.system.client.dtos.CartItemsDto;
import com.authservice.system.client.dtos.CartResponseDto;
import com.authservice.system.client.dtos.UpdateCartItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthCartService {

    private final OrderServiceClient cartServiceClient;

    public CartResponseDto createCart() {
        return cartServiceClient.createCart();
    }

    public CartResponseDto getCartDetails(String cartId) {
        return cartServiceClient.getCartDetails(cartId);
    }

    public CartItemsDto addToCart(String cartId, AddToCartRequest request) {
        ResponseEntity<CartItemsDto> response = cartServiceClient.addToCart(cartId, request);
        return response.getBody(); // unwrap Feign response
    }

    public CartItemsDto updateCartItem(String cartId, String productId, UpdateCartItemRequest request) {
        ResponseEntity<CartItemsDto> response = cartServiceClient.updateCartItem(cartId, productId, request);
        return response.getBody();
    }

    public void deleteCartItem(String cartId, String productId) {
        cartServiceClient.deleteCartItem(cartId, productId);
    }

    public void clearCart(String cartId) {
        cartServiceClient.clearCart(cartId);
    }
}
