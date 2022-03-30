package com.farmmart.data.repository.vendor;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.staticdata.BusinessEntity;
import com.farmmart.data.model.vendor.Vendor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendorRepositoryCustom {
    @Query("FROM Vendor v WHERE v.businessEntity=?1")
    List<Vendor> findByBusinessEntity(BusinessEntity businessEntity);

    @Query("FROM Vendor v WHERE v.name LIKE %?#{[0].toUpperCase()}%")
    Vendor findByName(String name);

    @Query("FROM Vendor v WHERE v.rcNumber=?1")
    Vendor findByRcNumber(String rcNumber);

    @Query("FROM Vendor v WHERE v.appUser=?1")
    Vendor findByUsername(AppUser appUser);
}
