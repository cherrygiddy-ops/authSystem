package com.authservice.system.client.controllers;

import com.authservice.system.auth.AuthService;
import com.authservice.system.client.dtos.CheckoutRequestDto;
import com.authservice.system.client.dtos.CheckoutResponseDto;
import com.authservice.system.client.dtos.OrderResponseDto;
import com.authservice.system.client.services.AuthCheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/checkout")
@RequiredArgsConstructor
public class AuthCheckoutController {

    private final AuthCheckoutService authCheckoutService;

    @PostMapping
    public CheckoutResponseDto checkout(@RequestBody CheckoutRequestDto requestDto) {
        // Pass cartId and phoneNumber to service
        return authCheckoutService.checkout(requestDto.getCartId(), requestDto.getPhoneNumber());
    }

    @PutMapping("/{orderId}/status/paid")
    public CheckoutResponseDto markOrderAsPaid(@PathVariable Long orderId) {
        return authCheckoutService.markOrderAsPaid(orderId);
    }

}

