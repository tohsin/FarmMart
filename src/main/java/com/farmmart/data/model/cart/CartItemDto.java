package com.farmmart.data.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    @JsonIgnore
    private Long id;

    private String productType;

    private String productName;

    private String productDescription;

    private Integer orderQuantity;

    private BigDecimal price;

    private String imageURL;

    private String soldBy;

//    private ProductAvailability productAvailability;

//    private Product product;

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setProductType(cart.getProduct().getProductType());
        this.setProductName(cart.getProduct().getProductName());
        this.setProductDescription(cart.getProduct().getProductDescription());
        this.setOrderQuantity(cart.getOrderQuantity());
        this.setPrice(cart.getProduct().getPrice());
        this.setImageURL(cart.getProduct().getImageURL());
        this.setSoldBy(cart.getProduct().getVendor().getName());
//        this.setProduct(cart.getProduct());
    }
}
