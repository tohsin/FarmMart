package com.farmmart.data.repository.localgovernment;

import com.farmmart.data.model.localgovernment.LocalGovernment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalGovernmentRepository extends JpaRepository<LocalGovernment,Long>,LocalGovernmentRepositoryCustom {
}
