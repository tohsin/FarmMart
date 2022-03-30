package com.farmmart.data.repository.customer;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.customer.Customer;
import com.farmmart.data.model.staticdata.AgeRange;
import com.farmmart.data.model.staticdata.Gender;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepositoryCustom {
    @Query("FROM Customer c WHERE c.firstName LIKE %?#{[0].toUpperCase()}%")
    List<Customer> findCustomerByFirstNameLike(String firstName);

    @Query("FROM Customer c WHERE c.lastName LIKE %?#{[0].toUpperCase()}%")
    List<Customer> findCustomerByLastNameLike(String lastName);

    @Query("FROM Customer c WHERE c.ageRange=?1")
    List<Customer> findCustomerByAgeRange(AgeRange ageRange);

    @Query("FROM Customer c WHERE c.gender=?1")
    List<Customer> findCustomerByGender(Gender gender);

    @Query("FROM Customer c WHERE c.appUser=?1")
    Customer findCustomerByUsername(AppUser appUser);
}
