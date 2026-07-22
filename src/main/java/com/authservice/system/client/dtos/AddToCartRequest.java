package com.authservice.system.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddToCartRequest {

    @JsonProperty("productId")
    private String productId;
}
