package com.farmmart.data.repository.state;

import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.state.States;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepositoryCustom {

    @Query("FROM States s WHERE s.stateName=?1")
    States findByStateName(String stateName);

    @Query("FROM States s WHERE s.country=?1")
    List<States> findStateByCountry(Country country);
}
