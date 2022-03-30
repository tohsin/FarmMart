package com.farmmart.data.model.cart;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCart {

    private Product product;

    private Integer orderQuantity;

    private AppUser appUser;
}
