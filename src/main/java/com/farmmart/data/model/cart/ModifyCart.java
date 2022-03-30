package com.farmmart.data.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyCart {

    private Long id;

    private Integer orderQuantity;

}
