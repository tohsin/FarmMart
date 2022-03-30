package com.farmmart.service.country;

import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.country.CountryNotFoundException;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country) throws CountryNotFoundException;
    Country findCountryById(Long id) throws CountryNotFoundException;
    Country findCountryByName(String countryName) throws CountryNotFoundException;
//    Page<Country> findAllCountry(Pageable page);
    List<Country> findAllCountries();
    Country updateCountry(Country country,Long id) throws CountryNotFoundException;
    void deleteCountryById(Long id) throws CountryNotFoundException;
    void deleteAllCountry();
}
