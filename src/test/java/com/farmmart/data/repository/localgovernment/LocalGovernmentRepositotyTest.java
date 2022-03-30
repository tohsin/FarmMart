package com.farmmart.data.repository.localgovernment;

import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.farmmart.data.model.localgovernment.LocalGovernmentNotFoundException;
import com.farmmart.data.model.state.States;
import com.farmmart.data.repository.state.StateRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
@Transactional
@Sql(scripts = {"classpath:db/insert.sql"})
class LocalGovernmentRepositoryTest {

    @Autowired
    private LocalGovernmentRepository localGovernmentRepository;

    @Autowired
    private StateRepository stateRepository;

    LocalGovernment localGovernment;

    States state;

    @BeforeEach
    void setUp() {
        localGovernment=new LocalGovernment();
        state=new States();
    }

    @Test
    void testThatYooCanSaveLocalGovernment(){
        String stateName="Lagos";
        state=stateRepository.findByStateName(stateName);

        localGovernment.setState(state);
        @NotBlank String localGovernmentName="Ikeja";
        localGovernment.setLocalGovernmentName(localGovernmentName);

        assertDoesNotThrow(()->localGovernmentRepository.save(localGovernment));

        assertEquals(localGovernmentName,localGovernment.getLocalGovernmentName());

        log.info("Saved Local Govt.:{}",localGovernment);
    }

    @Test
    void testThatYouCanFindLocalGovernmentById() throws LocalGovernmentNotFoundException {
        Long id=3L;
        localGovernment=localGovernmentRepository.findById(id).orElseThrow(()->new LocalGovernmentNotFoundException("Local Govt. Not Found"));

        assertEquals(3,localGovernment.getId());

        log.info("Local Govt. 3:{}",localGovernment.getLocalGovernmentName());
    }

    @Test
    void testThatYouCanFindLocalGovernmentByName() throws LocalGovernmentNotFoundException {
        String localGovernmentName="Epe";

        localGovernment=localGovernmentRepository.findByLocalGovernmentName(localGovernmentName);

        if (localGovernment==null){
            throw new LocalGovernmentNotFoundException("Local Govt. Not Found");
        }

        assertEquals(localGovernmentName,localGovernment.getLocalGovernmentName());

        log.info("Local Govt. :{}",localGovernment);
    }

    @Test
    void testThatYouCanFindAllLocalGovernments(){
        List<LocalGovernment> localGovernments=localGovernmentRepository.findAll();

        assertEquals(6,localGovernments.size());

        log.info("Local Governments:{}",localGovernments);
    }

    @Test
    void testThatYouCanFindStateLocalGovernments(){
        String stateName="Lagos";
        state=stateRepository.findByStateName(stateName);

        List<LocalGovernment> localGovernments=localGovernmentRepository.findLocalGovernmentByState(state);

        log.info("State Local Govt:{}",localGovernments);
    }

    @Test
    void testThatYouCanUpdateLocalGovernment() throws LocalGovernmentNotFoundException {
        Long id=3L;
        localGovernment=localGovernmentRepository.findById(id).orElseThrow(()->new
                LocalGovernmentNotFoundException("Local Govt. Not Found"));

        @NotBlank(message = "Add Local Government Name") String localGovtName="Amuwo";
        localGovernment.setLocalGovernmentName(localGovtName);

        assertDoesNotThrow(()->localGovernmentRepository.save(localGovernment));

        assertEquals(localGovtName,localGovernment.getLocalGovernmentName());

        log.info("Updated Local Govt:{}",localGovernment.getLocalGovernmentName());
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteLocalGovernmentById() throws LocalGovernmentNotFoundException {
        Long id=5L;
        localGovernmentRepository.deleteById(id);

        Optional<LocalGovernment> optionalLocalGovernment=localGovernmentRepository.findById(id);

        if (optionalLocalGovernment.isPresent()){
            throw new LocalGovernmentNotFoundException("Local Govt "+id+" Is Not Deleted");
        }
    }

    @Rollback
    @Test
    void testThaYouCanDeleteAllLocalGovernment(){
        localGovernmentRepository.deleteAll();

        log.info("Local Govt:{}",localGovernment);
    }
}