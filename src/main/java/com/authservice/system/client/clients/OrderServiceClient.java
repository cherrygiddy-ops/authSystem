package com.authservice.system.client.clients;

import com.authservice.system.client.dtos.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@FeignClient(name = "order-service", path = "/orders")
public interface OrderServiceClient {

    // Products
    @PostMapping("/products")
    ProductsResponseDto addProduct(@RequestBody ProductsRequestDto request);

    @GetMapping("/products/{productId}")
    ProductsResponseDto getProductDetails(@PathVariable("productId") Integer productId);

    @GetMapping("/products")
    List<ProductsResponseDto> getProducts(
            @RequestParam(required = false) Byte categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String sortBy
    );

    @DeleteMapping("/products/{productId}")
    void deleteProduct(@PathVariable("productId") Integer productId);

    @PutMapping("/products/{productId}")
    ProductsResponseDto updateProduct(
            @PathVariable("productId") Integer productId,
            @RequestBody UpdateProductRequest request
    );


    // Carts

        @PostMapping("/carts")
        CartResponseDto createCart();

        @GetMapping("/carts/{cartId}")
        CartResponseDto getCartDetails(@PathVariable("cartId") String cartId);

        @PostMapping("/carts/{cartId}/items")
        ResponseEntity<CartItemsDto> addToCart(@PathVariable("cartId") String cartId,
                                               @RequestBody AddToCartRequest request);

    @PutMapping("/carts/{cartId}/items/{productId}")
    ResponseEntity<CartItemsDto> updateCartItem(@PathVariable("cartId") String cartId,
                                                @PathVariable("productId") String productId,
                                                @RequestBody UpdateCartItemRequest request);


    @DeleteMapping("/carts/{cartId}/items/{productId}")
        void deleteCartItem(@PathVariable("cartId") String cartId,
            @PathVariable("productId") String productId);

        @DeleteMapping("/carts/{cartId}/items")
        void clearCart(@PathVariable("cartId") String cartId);

    @PostMapping("/checkout")
    CheckoutResponseDto checkout(@RequestBody CheckoutRequestDto requestDto);

    @PutMapping("/{orderId}/status/paid")
    CheckoutResponseDto markOrderAsPaid(@PathVariable("orderId") Long orderId);

    @GetMapping()
    List<OrderResponseDto> getAllOrders();

    @GetMapping("/{orderId}")
    OrderResponseDto getOrderById(@PathVariable("orderId") Long orderId);

}

