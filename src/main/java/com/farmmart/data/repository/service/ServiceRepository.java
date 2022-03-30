package com.farmmart.data.repository.service;

import com.farmmart.data.model.services.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>, ServiceRepositoryCustom {
}
