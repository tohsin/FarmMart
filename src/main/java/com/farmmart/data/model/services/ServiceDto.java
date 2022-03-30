package com.farmmart.data.model.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

    private Long id;

    private String serviceName;

    private String serviceDescription;

    private String categoryName;

    private String vendorName;
}
