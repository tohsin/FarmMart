package com.farmmart.data.repository.country;

import com.farmmart.data.model.country.Country;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepositoryCustom {

    @Query("FROM Country c WHERE c.countryName=?1")
    Country findByCountyName(String countryName);
}
