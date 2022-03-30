package com.farmmart.data.model.cart;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.product.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Product product;

    private Integer orderQuantity;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private AppUser appUser;
}
