package com.farmmart.data.repository.order;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.order.CustomerOrder;
import com.farmmart.data.repository.appuser.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Slf4j
@Transactional
@Sql(scripts = {"classpath:db/insert.sql"})
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    CustomerOrder order;

    AppUser appUser;

    @BeforeEach
    void setUp() {
        order=new CustomerOrder();
        appUser=new AppUser();
    }

    @Test
    void testThatYouCanSaveOrder(){
        String username="BukolaFako";
        appUser=appUserRepository.findByUserName(username);

        order.setAppUser(appUser);
        order.setOrderDate(new Date());
        order.setOrderTotal(BigDecimal.valueOf(16000));

        log.info("Order repo before saving: {}", order);

        assertDoesNotThrow(()-> orderRepository.save(order));

        log.info("Order repo after saving: {}", order);
    }

    @Test
    void testThatYouCanFindOrderByCustomerId(){
        String username="BukolaFako";
        appUser=appUserRepository.findByUserName(username);

        List<CustomerOrder> orders=orderRepository.findOrderByAppUsername(appUser);

        log.info("Customer orders: {}", orders);
    }

    @Test
    void testThatYouCanFindAllOrder(){

        List<CustomerOrder> orders=orderRepository.findAll();

        log.info("Orders: {}", orders);
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteAllOrders() throws Exception {

        orderRepository.deleteAll();
    }
}