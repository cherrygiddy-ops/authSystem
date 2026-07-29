package com.authservice.system.client.services;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.CheckoutRequestDto;
import com.authservice.system.client.dtos.CheckoutResponseDto;
import com.authservice.system.client.dtos.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthCheckoutService {

    private final OrderServiceClient orderServiceClient;

    public CheckoutResponseDto checkout(String cartId, String phoneNumber) {
        // Build request DTO with matching field names
        CheckoutRequestDto request = new CheckoutRequestDto();
        request.setCartId(cartId);          // String cartId, matches JSON
        request.setPhoneNumber(phoneNumber);

        // Delegate to Feign client
        return orderServiceClient.checkout(request);
    }

    public CheckoutResponseDto markOrderAsPaid(Long orderId) {
        return orderServiceClient.markOrderAsPaid(orderId);
    }
}

