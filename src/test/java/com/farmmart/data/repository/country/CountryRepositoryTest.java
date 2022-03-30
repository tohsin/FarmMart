package com.farmmart.data.repository.country;

import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.country.CountryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class CountryRepositoryTest {
    @Autowired
    private CountryRepository countryRepository;

    Country country;

    @BeforeEach
    void setUp() {
        country=new Country();
    }

    @Test
    void tesThatYouCanSaveCountry(){
        country.setCountryName("Angola");

        assertDoesNotThrow(()->countryRepository.save(country));

        assertEquals("Angola",country.getCountryName());

        log.info("Country repo {}",country.getCountryName());
    }
    
    @Test
    void testThatYouCanFindCountryById() throws CountryNotFoundException {
        Long id=1L;
        country=countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException("Country Not Found"));

        assertEquals("Kenya",country.getCountryName());//test to fail

        log.info("Country Id 1: {}",country.getCountryName());
    }

    @Test
    void testThatYouCanFindCountryByName() throws CountryNotFoundException {
        String countryName="Ghana";

        country= countryRepository.findByCountyName(countryName);

        if (country==null){
            throw new CountryNotFoundException("Country "+countryName+" does not exist");
        }

        assertEquals("Ghana",country.getCountryName());

        log.info("Country: {}",country);
    }

    @Test
    void testThaYouCanFindAllCountries(){
        List<Country> countries=countryRepository.findAll();

        assertEquals(3,countries.size());

        log.info("Country list: {}",countries);
    }

    @Test
    void testThatYouCanUpdateCountry(){
        String countryName="Nigeria";
        country=countryRepository.findByCountyName(countryName);

        country.setCountryName("Federal Republic of Nigeria");

        assertDoesNotThrow(()->countryRepository.save(country));

        assertEquals("Federal Republic of Nigeria",country.getCountryName(),"Invalid Country name");

        log.info("Updated country name {}",country.getCountryName());
    }

    @Test
    void testThatYouCanDeleteCountryById() throws CountryNotFoundException {
        Long id=3L;
        countryRepository.deleteById(id);

        Optional<Country> optionalCountry=countryRepository.findById(id);

        if (optionalCountry.isPresent()){
            throw new CountryNotFoundException("Country id "+id+" is not deleted");
        }

        log.info("Deleting country id 1 is:{}",country.getCountryName());
    }

    @Test
    void testThatYouCanDeleteAllCountries(){
        countryRepository.deleteAll();

        log.info("Deleting repo record {}",country);
    }
}