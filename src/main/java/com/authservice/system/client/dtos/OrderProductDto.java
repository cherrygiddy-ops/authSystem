package com.authservice.system.client.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductDto {
    private String id;
    private String name;
    private BigDecimal price;
}
