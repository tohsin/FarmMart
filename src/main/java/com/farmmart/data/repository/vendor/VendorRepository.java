package com.farmmart.data.repository.vendor;

import com.farmmart.data.model.vendor.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>,VendorRepositoryCustom {
}
