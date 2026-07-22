package com.authservice.system.client.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductDto {
    private String id;
    private String name;
    private BigDecimal price=BigDecimal.ZERO;
    private String imageUrl;
}
