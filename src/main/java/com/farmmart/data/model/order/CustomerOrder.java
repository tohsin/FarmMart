package com.farmmart.data.model.order;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.orderitem.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalVAT;

    private BigDecimal orderTotal;

    @CreationTimestamp
    private Date orderDate;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private AppUser appUser;

    @OneToMany(mappedBy = "customerOrder",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<OrderItem> orderDetails;
}
