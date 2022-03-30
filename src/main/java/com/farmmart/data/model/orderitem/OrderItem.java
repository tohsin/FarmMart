package com.farmmart.data.model.orderitem;

import com.farmmart.data.model.order.CustomerOrder;
import com.farmmart.data.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdDate;

    private Integer orderQuantity;

    private BigDecimal price;

    @JsonIgnore
    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerOrder customerOrder;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;
}
