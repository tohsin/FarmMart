package com.farmmart.dto.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutItemDto {

    private String productName;
    private Integer quantity;
    private BigDecimal price;
    private Long productId;
    private Long customerId;
}
