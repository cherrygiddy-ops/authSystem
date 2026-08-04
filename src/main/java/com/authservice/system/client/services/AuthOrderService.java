package com.authservice.system.client.services;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.OrderResponseDto;
import com.authservice.system.client.dtos.OrderSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AuthOrderService {
    private final OrderServiceClient orderServiceClient;

    // List all orders
    public List<OrderResponseDto> getAllOrders() {
        return orderServiceClient.getAllOrders();
    }

    // Get specific order by ID
    public OrderResponseDto getOrderById(Long orderId) {
        return orderServiceClient.getOrderById(orderId);
    }
    public OrderSummaryDto getOrderSummary() {
        return orderServiceClient.getOrderSummary();
    }
}
