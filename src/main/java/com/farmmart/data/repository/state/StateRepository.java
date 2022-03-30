package com.farmmart.data.repository.state;

import com.farmmart.data.model.state.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<States,Long>,StateRepositoryCustom {
}
