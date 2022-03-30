package com.farmmart.data.model.product;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.colour.Colour;
import com.farmmart.data.model.staticdata.ProductAvailability;
import com.farmmart.data.model.staticdata.ProductCondition;
import com.farmmart.data.model.staticdata.UnitOfMeasure;
import com.farmmart.data.model.vendor.Vendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProduct {

    private String productType;

    private String productName;

    private String productDescription;

    private Integer stockQuantity;

    private BigDecimal price;

    private String weight;

    private String brand;

    private String productStyle;

    private String productDimension;

    private String partNumber;

    private String productSKU;

    private ProductCondition productCondition;

    private UnitOfMeasure unitOfMeasure;

    private ProductAvailability productAvailability;

    private Category category;

    private Collection<Colour> colours;

    private Vendor vendor;
}
