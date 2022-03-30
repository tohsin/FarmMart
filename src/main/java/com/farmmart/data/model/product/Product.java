package com.farmmart.data.model.product;

import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.cart.Cart;
import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.colour.Colour;
import com.farmmart.data.model.staticdata.ProductAvailability;
import com.farmmart.data.model.staticdata.ProductCondition;
import com.farmmart.data.model.staticdata.UnitOfMeasure;
import com.farmmart.data.model.vendor.Vendor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

/**@author :Sunlola Fakolujo
 * @created: 22-02-2022 08:50
 * @project: FarmMart Ecommerce
 */

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseAudit {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String productType;

    private String productName;

//    @Lob
//    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private String imageURL;


    /**
     * Text Area
     */
    @Size(max = 10000)
    private String productDescription;

    /**
     * Number field component
     */
    @Positive(message = "Enter positive quantity")
    private Integer stockQuantity;

    /**
     * BigDecimal Field component
     * or combine with Custom field
     */

    @Positive(message = "Enter positive value")
    private BigDecimal price;

    private String weight;

    private String brand;

    private String productStyle;

    private String productDimension;

    private String partNumber;

    private String productSKU;

    /**
     * combo box
     */
    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition;

    /**
     * combo box
     */
    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unitOfMeasure;

    /**
     * combo box
     */
    @Enumerated(EnumType.STRING)
    private ProductAvailability productAvailability;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Collection<Colour> colours;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Vendor vendor;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Cart> carts;
}
