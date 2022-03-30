package com.farmmart.data.model.order;

import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerItemDto {

    private BigDecimal price;

    private Integer quantity;

    private Long orderId;

    private Long productId;
}
