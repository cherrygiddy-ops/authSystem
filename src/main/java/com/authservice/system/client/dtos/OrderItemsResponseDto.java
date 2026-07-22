package com.authservice.system.client.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemsResponseDto {
    private OrderProductDto product;
    private Integer quantity;
    private BigDecimal totalPrice;
}
