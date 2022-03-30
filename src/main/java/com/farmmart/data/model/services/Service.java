package com.farmmart.data.model.services;

import com.farmmart.data.model.baseaudit.BaseAudit;
import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.vendor.Vendor;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Service extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String serviceDescription;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Vendor vendor;


}
