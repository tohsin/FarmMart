package com.farmmart.data.repository.country;

import com.farmmart.data.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>,CountryRepositoryCustom {
}
