package com.farmmart.service.address;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.address.AddressNotFoundException;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.farmmart.data.repository.address.AddressRepository;
import com.farmmart.data.repository.localgovernment.LocalGovernmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})
class AddressServiceImplTest {
    @Mock
    private AddressRepository addressRepository;

    @Mock
    private LocalGovernmentRepository localGovernmentRepository;

    @InjectMocks
    private AddressService addressService=new AddressServiceImpl();

    Address address;

    LocalGovernment localGovernment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address=new Address();
        localGovernment=new LocalGovernment();
    }

    @Test
    void testThatYouCanMockSaveAddressMethod() throws AddressNotFoundException {

        Mockito.when(addressRepository.save(address)).thenReturn(address);

        addressService.saveAddress(address);

        ArgumentCaptor<Address> addressArgumentCaptor=ArgumentCaptor.forClass(Address.class);

        Mockito.verify(addressRepository,Mockito.times(1)).save(addressArgumentCaptor.capture());

        Address capturedAddress=addressArgumentCaptor.getValue();

        assertEquals(capturedAddress,address);
    }

    @Test
    void testThatYouCanMockFindAddressByIdMethod() throws AddressNotFoundException {
        Long id=2L;
        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        addressService.findAddressById(id);

        Mockito.verify(addressRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void testThatYouCanMockFindAllAddressesMethod() {
        List<Address> addresses=new ArrayList<>();

        Mockito.when(addressRepository.findAll()).thenReturn(addresses);

        addressService.findAllAddresses();

        Mockito.verify(addressRepository,Mockito.times(1)).findAll();

    }

    @Test
    void testThatYouCanMockFindAddressesByLocalGovernmentMethod() {
        String localGovernmentName="Amuwo Odofin";
        localGovernment=localGovernmentRepository.findByLocalGovernmentName(localGovernmentName);

        List<Address> addresses=new ArrayList<>();

        Mockito.when(addressRepository.findAddressesByLocalGovernment(localGovernment)).thenReturn(addresses);

        addressService.findAddressesByLocalGovernment(localGovernment,localGovernmentName);

        Mockito.verify(addressRepository,Mockito.times(1)).findAddressesByLocalGovernment(localGovernment);
    }

    @Test
    void testThatYouCanMockUpdateAddressMethod() throws AddressNotFoundException {
        Long id=1L;
        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        addressService.updateAddress(address,id);

        Mockito.verify(addressRepository,Mockito.times(1)).save(address);
    }

    @Test
    void testThatYouCanMockDeleteAddressByIdMethod() throws AddressNotFoundException {
        Long id=2L;
        doNothing().when(addressRepository).deleteById(id);

        addressService.deleteAddressById(id);

        verify(addressRepository,times(1)).deleteById(id);
    }

    @Test
    void testThatYouCanMockDeleteAllAddressesMethod() {
        doNothing().when(addressRepository).deleteAll();

        addressService.deleteAllAddresses();

        verify(addressRepository,times(1)).deleteAll();
    }
}