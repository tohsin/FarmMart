package com.farmmart.data.repository.service;

import com.farmmart.data.model.category.Category;
import com.farmmart.data.model.services.Service;
import com.farmmart.data.model.services.ServiceNotFoundException;
import com.farmmart.data.model.vendor.Vendor;
import com.farmmart.data.model.vendor.VendorNotFoundException;
import com.farmmart.data.repository.category.CategoryRepository;
import com.farmmart.data.repository.vendor.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Transactional
@Sql(scripts = {"classpath:db/insert.sql"})
class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VendorRepository vendorRepository;

    Service service;
    Category category;
    Vendor vendor;

    @BeforeEach
    void setUp() {
        service=new Service();
        category=new Category();
        vendor=new Vendor();
    }

    @Test
    void testThatYouCanAddService() throws ServiceNotFoundException, VendorNotFoundException {
        category=categoryRepository.findById(39L).orElseThrow(()->new ServiceNotFoundException("Service Not Found"));

        vendor=vendorRepository.findById(3L).orElseThrow(()-> new VendorNotFoundException("Vendor Not Found"));

        service.setServiceName("Root Crop");
        service.setServiceDescription("Planting and management of root crops");
        service.setCategory(category);
        service.setVendor(vendor);

        log.info("Service repo before saving {}", service);

        Assertions.assertDoesNotThrow(()->serviceRepository.save(service));

        log.info("Service repo after saving {}", service);
    }

    @Test
    void testThatYouCanFindServiceById() throws ServiceNotFoundException {
        Long id =3L;
        service=serviceRepository.findById(id).orElseThrow(()->new ServiceNotFoundException("Service Not Found"));

        assertEquals("Composting",service.getServiceName());

        log.info("Service {}", service);
    }

    @Test
    void testThatYouCanFindServiceByName() throws ServiceNotFoundException {
        String name="Grooming";

        service=serviceRepository.findByServiceName(name);

        if (Objects.isNull(service)){
            throw new ServiceNotFoundException("Service "+name+" Not Found");
        }

        assertEquals(name,service.getServiceName());

        log.info("Service {}", service);
    }

    @Test
    void testThatYouCanFindAllServices(){

        List<Service> services=serviceRepository.findAll();

        log.info("Service {}", services);
    }

    @Test
    void testThatYouCanUpdateService() throws ServiceNotFoundException {
        Long id=2L;
        service=serviceRepository.findById(id).orElseThrow(()->new ServiceNotFoundException("Service Not Found"));

        service.setServiceName("Grading");

        assertDoesNotThrow(()->serviceRepository.save(service));

        assertEquals("Grading",service.getServiceName());

        log.info("Service: {}", service.getServiceName());
    }

    @Rollback(value = false)
    @Test
    void testThatYoCanDeleteServiceById() throws ServiceNotFoundException {
        Long id=2L;
        serviceRepository.deleteById(id);

        Optional<Service> optionalService=serviceRepository.findById(id);

        if (optionalService.isPresent()){
            throw new ServiceNotFoundException("Service id "+id+" is not deleted");
        }
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteAllServices(){
        serviceRepository.deleteAll();
    }

}