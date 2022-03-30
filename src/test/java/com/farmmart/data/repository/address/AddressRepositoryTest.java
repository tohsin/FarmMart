package com.farmmart.data.repository.address;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.address.AddressNotFoundException;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.farmmart.data.model.state.States;
import com.farmmart.data.repository.localgovernment.LocalGovernmentRepository;
import com.farmmart.data.repository.state.StateRepository;
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
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocalGovernmentRepository localGovernmentRepository;

    @Autowired
    private StateRepository stateRepository;

    States state;

    Address address;

    LocalGovernment localGovernment;

    @BeforeEach
    void setUp() {
        address=new Address();
        localGovernment=new LocalGovernment();
        state=new States();
    }

    @Test
    void testThatYouCanAddAddress(){
        String localGovernmentName="Amuwo Odofin";
        localGovernment=localGovernmentRepository.findByLocalGovernmentName(localGovernmentName);

        address.setStreetNumber("Block 433, Flat 1");
        address.setStreetName("Amuwo Odofin Housing Estate");
        address.setCity("Mile 2");
        address.setPostZipCode("");
        address.setLocalGovernment(localGovernment);

        assertDoesNotThrow(()->addressRepository.save(address));

        log.info("New Address: {}",address);
    }

    @Test
    void testThatYouCanFindAddressById() throws AddressNotFoundException {
        Long id=1L;
        address=addressRepository.findById(id).orElseThrow(()->new AddressNotFoundException("Address Not Found"));

        assertEquals(id,address.getId());

        log.info("Address Id 1: {}",address);
    }

    @Test
    void testThatYouCanFindAllAddresses(){
        List<Address> addresses=addressRepository.findAll();

        assertEquals(2,addresses.size());

        log.info("Addresses: {}",addresses);
    }

    @Test
    void testThatYouCanFindLocalGovernmentAddress(){
        String localGovernmentName="Amuwo Odofin";
        localGovernment=localGovernmentRepository.findByLocalGovernmentName(localGovernmentName);

        List<Address> addresses=addressRepository.findAddressesByLocalGovernment(localGovernment);

        log.info("Local Govt. Addresses: {}",addresses);
    }

    @Test
    void testThatYouCanUpdateAddress() throws AddressNotFoundException {
        localGovernment.setLocalGovernmentName("Eti Osa");
        state=stateRepository.findByStateName("Lagos");

        localGovernment.setState(state);
        Long id=1L;
        address=addressRepository.findById(id).orElseThrow(()->new AddressNotFoundException("Address Not Found"));
        address.setLocalGovernment(localGovernment);
        address.setCity("Victoria Island");
        address.setStreetNumber("32");
        address.setStreetName("Ozumba Mbadiwe Avenue");

        assertDoesNotThrow(()->addressRepository.save(address));

        log.info("Updated Address:{}",address);
    }

    @Rollback
    @Test
    void testThatYouCanDeleteAddressById() throws AddressNotFoundException {
        Long id=2L;
        addressRepository.deleteById(id);

        Optional<Address> optionalAddress=addressRepository.findById(id);

        if (optionalAddress.isPresent()){
            throw new AddressNotFoundException("Address id "+id+" Is Not Deleted");
        }
    }

    @Rollback
    @Test
    void testThatYouCanDeleteAllAddresses(){
        addressRepository.deleteAll();
    }


}