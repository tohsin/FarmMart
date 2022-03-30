package com.farmmart.service.address;

import com.farmmart.data.model.address.Address;
import com.farmmart.data.model.address.AddressNotFoundException;
import com.farmmart.data.model.localgovernment.LocalGovernment;
import com.farmmart.data.repository.address.AddressRepository;
import com.farmmart.data.repository.localgovernment.LocalGovernmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocalGovernmentRepository localGovernmentRepository;

    @Override
    public Address saveAddress(Address address) throws AddressNotFoundException {

        if (address==null){
            throw new AddressNotFoundException("Address Is Not Created");
        }

        return addressRepository.save(address);
    }

    @Override
    public Address findAddressById(Long id) throws AddressNotFoundException {

        Address address=addressRepository.findById(id).orElseThrow(()->new AddressNotFoundException("Address Not Found"));

        return address;
    }

    @Override
    public List<Address> findAllAddresses() {

        return addressRepository.findAll();
    }

    @Override
    public List<Address> findAddressesByLocalGovernment(LocalGovernment localGovernment,String localGovernmentName) {

        localGovernment=localGovernmentRepository.findByLocalGovernmentName(localGovernmentName);

        return addressRepository.findAddressesByLocalGovernment(localGovernment);
    }

    @Override
    public Address updateAddress(Address address, Long id) throws AddressNotFoundException {
        Address savedAddress=addressRepository.findById(id).orElseThrow(()->new AddressNotFoundException("Address Not Found"));

        if (address.getStreetNumber()!=null) {
            savedAddress.setStreetNumber(address.getStreetNumber());
        }if (address.getStreetName()!=null){
            savedAddress.setStreetName(address.getStreetName());
        }if (address.getCity()!=null){
            savedAddress.setCity(address.getCity());
        }if (address.getPostZipCode()!=null){
            savedAddress.setPostZipCode(address.getPostZipCode());
        }if (address.getLocalGovernment()!=null){
            savedAddress.setLocalGovernment(address.getLocalGovernment());
        }

        return addressRepository.save(savedAddress);
    }

    @Override
    public void deleteAddressById(Long id) throws AddressNotFoundException {

        addressRepository.deleteById(id);

        Optional<Address> optionalAddress=addressRepository.findById(id);

        if (optionalAddress.isPresent()){
            throw new AddressNotFoundException("Address Id "+id+" Is No deleted");
        }
    }

    @Override
    public void deleteAllAddresses() {

        addressRepository.deleteAll();
    }
}
