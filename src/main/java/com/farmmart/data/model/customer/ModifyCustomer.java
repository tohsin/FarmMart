package com.farmmart.data.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyCustomer {
    private Long id;

    private String firstName;

    private String lastName;
}
