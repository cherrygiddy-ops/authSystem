package com.authservice.system.client.services;

import com.authservice.system.client.clients.OrderServiceClient;
import com.authservice.system.client.dtos.OrderResponseDto;
import com.authservice.system.client.dtos.ProductsRequestDto;
import com.authservice.system.client.dtos.ProductsResponseDto;
import com.authservice.system.client.dtos.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderIntegrationService {

    private final OrderServiceClient orderServiceClient;

    // Product endpoints
    public ProductsResponseDto addProduct(ProductsRequestDto request) {
        return orderServiceClient.addProduct(request);
    }

    public ProductsResponseDto getProductDetails(Integer productId) {
        return orderServiceClient.getProductDetails(productId);
    }

    // ✅ Unified product listing with category, keyword, and sort filters
    public List<ProductsResponseDto> getProducts(Byte categoryId, String keyword, String sortBy) {
        return orderServiceClient.getProducts(categoryId, keyword, sortBy);
    }

    public void deleteProduct(Integer productId) {
        orderServiceClient.deleteProduct(productId);
    }

    public ProductsResponseDto updateProduct(Integer productId, UpdateProductRequest request) {
        return orderServiceClient.updateProduct(productId, request);
    }

    // Order endpoints
    public List<OrderResponseDto> getOrdersByCustomer(String customerId) {
        return orderServiceClient.getOrdersByCustomer(customerId);
    }

    public OrderResponseDto getOrderById(String orderId) {
        return orderServiceClient.getOrderById(orderId);
    }
}
