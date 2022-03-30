package com.farmmart.data.model.wishlist;

import com.farmmart.data.model.customer.Customer;
import com.farmmart.data.model.product.Product;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdDate;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne
    private Product product;
}
