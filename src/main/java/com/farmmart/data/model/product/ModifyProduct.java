package com.farmmart.data.model.product;

import com.farmmart.data.model.colour.Colour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyProduct {

    private Long id;

    private Integer stockQuantity;

    private BigDecimal price;

    private Collection<Colour> colours;


}
