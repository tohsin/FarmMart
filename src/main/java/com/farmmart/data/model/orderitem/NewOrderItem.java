package com.farmmart.data.model.orderitem;

import com.farmmart.data.model.order.CustomerOrder;
import com.farmmart.data.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderItem {

    private CustomerOrder customerOrder;

    private Product product;

    private Integer orderQuantity;

    private BigDecimal amount;
}
