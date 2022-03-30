package com.farmmart.service.address;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.address.AddressNotFoundException;
import com.farmmart.data.model.localgovernment.LocalGovernment;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address) throws AddressNotFoundException;
    Address findAddressById(Long id) throws AddressNotFoundException;
    List<Address> findAllAddresses();
    List<Address> findAddressesByLocalGovernment(LocalGovernment localGovernment,String localGovernmentName);
    Address updateAddress(Address address, Long id) throws AddressNotFoundException;
    void deleteAddressById(Long id) throws AddressNotFoundException;
    void deleteAllAddresses();
}
