package com.authservice.system.client.controllers;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.OrderResponseDto;
import com.authservice.system.client.services.AuthOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/orders")
public class AuthOrdersController {

    private final AuthOrderService authOrderService;


    @GetMapping("/{orderId}")
    public OrderResponseDto getOrderById(@PathVariable Long orderId) {
        return authOrderService.getOrderById(orderId);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return authOrderService.getAllOrders();
    }
}
