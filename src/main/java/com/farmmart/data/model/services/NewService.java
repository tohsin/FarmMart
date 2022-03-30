package com.farmmart.data.model.services;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.vendor.Vendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewService {

    private String serviceName;

    private String serviceDescription;

    private Category category;

    private Vendor vendor;
}
