package com.farmmart.data.repository.address;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepositoryCustom {
    @Query("FROM Address a WHERE a.localGovernment=?1")
    List<Address> findAddressesByLocalGovernment(LocalGovernment localGovernment);
}
