package com.authservice.system.client.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class ProductsRequestDto {
    private String id;
    private String name;
    private String descriptions;
    private Integer quantity;
    private BigDecimal price;
    private Byte categoryId;

}
