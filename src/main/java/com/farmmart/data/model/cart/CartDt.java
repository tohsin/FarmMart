package com.farmmart.data.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDt {

    @JsonIgnore
    private Long id;

    private String productType;

    private String productName;

    private String productDescription;

    private String imageURL;

    private BigDecimal productPrice;

    private Integer orderQuantity;

}
