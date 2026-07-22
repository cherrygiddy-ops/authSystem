package com.authservice.system.client.controllers;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/orders")
public class AuthOrdersController {

    private final OrderServiceClient orderServiceClient;

    // Order endpoints
    public List<OrderResponseDto> getOrdersByCustomer(String customerId) {
        return orderServiceClient.getOrdersByCustomer(customerId);
    }

    public OrderResponseDto getOrderById(String orderId) {
        return orderServiceClient.getOrderById(orderId);
    }
}
