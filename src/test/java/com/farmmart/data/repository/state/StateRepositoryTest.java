package com.farmmart.data.repository.state;

import com.farmmart.data.model.country.Country;
import com.farmmart.data.model.country.CountryNotFoundException;
import com.farmmart.data.model.state.StateNotFoundException;
import com.farmmart.data.model.state.States;
import com.farmmart.data.repository.country.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
@Sql(scripts = {"classpath:db/insert.sql"})
class StateRepositoryTest {

    @Autowired
    private StateRepository stateRepository;

    States state;

    @Autowired
    private CountryRepository countryRepository;

    Country country;

    @BeforeEach
    void setUp() {
        state=new States();
        country=new Country();
    }

    @Test
    void testThatYouCanSaveState() throws CountryNotFoundException {
        Long id=1L;
        country=countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException("State Not Found"));

        String stateName="Jigawa";
        state.setStateName(stateName);
        state.setCountry(country);

        assertDoesNotThrow(()-> stateRepository.save(state));

        assertEquals(stateName,state.getStateName());

        log.info("New State:{}",state);
    }

    @Test
    void testThatYouCanFindStateById() throws StateNotFoundException {
        Long id=5L;
        state=stateRepository.findById(id).orElseThrow(()->new StateNotFoundException("State Not Found"));

        assertEquals(5,state.getId());

        log.info("State with Id 5:{}",state);
    }

    @Test
    void testThatYouCanFindStateByName() throws StateNotFoundException {
        String stateName="Oyo";
        state=stateRepository.findByStateName(stateName);

        if (state==null){
            throw new StateNotFoundException("State "+stateName+" Not Found");
        }

        assertEquals(stateName,state.getStateName());

        log.info("State: {}",state.getStateName());
    }

    @Test
    void testThatYouCanFindStatesByCountry(){
        String countryName="Nigeria";
        country=countryRepository.findByCountyName(countryName);

        assertEquals(countryName,country.getCountryName());

        List<States> statesList=stateRepository.findStateByCountry(country);

        log.info("States in Nigeria: {}",statesList);
    }

    @Test
    void testThatYouCanFindAllStates(){
        Integer size=6;
        List<States> states=stateRepository.findAll();

        assertEquals(size,states.size());

        log.info("States:{}",states);
        log.info("Size:{}",states.size());
    }

    @Test
    void testThatYouCanUpdateState(){
        String statteName="Lagos";
        state=stateRepository.findByStateName(statteName);

        String stateUpdate="Eko";
        state.setStateName(stateUpdate);

        assertDoesNotThrow(()->stateRepository.save(state));

        assertEquals(stateUpdate,state.getStateName());

        log.info("State name update:{}",state.getStateName());
    }

    @Rollback(value = false)
    @Test
    void testThatyouCanDeleteStateById() throws StateNotFoundException {
        Long id=6L;
        stateRepository.deleteById(id);

        Optional<States> optionalStates=stateRepository.findById(id);

        if (optionalStates.isPresent()){
            throw new StateNotFoundException("State Id "+id+ " is not deleted");
        }

        log.info("State id 6:{}",state.getStateName());
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteAllStates(){
        stateRepository.deleteAll();

        assertNotNull(state);

        log.info("State repo:{}",state);
    }
}