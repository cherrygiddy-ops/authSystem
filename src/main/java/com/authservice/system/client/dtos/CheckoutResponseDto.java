package com.authservice.system.client.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CheckoutResponseDto {
    private Long orderId;
    private String stripeCheckoutUrl;
    private String PhoneNumber;
}
