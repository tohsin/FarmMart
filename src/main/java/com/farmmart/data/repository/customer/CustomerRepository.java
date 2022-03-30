package com.farmmart.data.repository.customer;

import com.farmmart.data.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>, CustomerRepositoryCustom {
}
