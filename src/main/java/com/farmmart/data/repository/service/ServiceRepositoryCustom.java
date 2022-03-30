package com.farmmart.data.repository.service;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.services.Service;
import com.farmmart.data.model.vendor.Vendor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepositoryCustom {

    @Query("From Service s Where s.serviceName Like %?#{[0].toUpperCase()}%")
    Service findByServiceName(String serviceName);

    @Query("From Service s Where s.category=?1")
    List<Service> findServiceByCategory(Category category);

    @Query("From Service s Where s.vendor=?1")
    List<Service> findServiceByVendor(Vendor vendor);
}
