package com.authservice.system.client.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CheckoutRequestDto {
    @NotBlank(message = "cartID Required")
    private String cartId;
    private String paymentMethod;
    private String PhoneNumber;
}
