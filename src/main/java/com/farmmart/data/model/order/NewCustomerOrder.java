package com.farmmart.data.model.order;

import com.farmmart.data.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCustomerOrder {

    private BigDecimal amount;

    private Date orderDate;

    private Customer customer;
}
