package com.farmmart.data.repository.cart;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.cart.Cart;
import com.farmmart.data.model.cart.CartNotFoundException;
import com.farmmart.data.model.product.Product;
import com.farmmart.data.model.product.ProductNotFoundException;
import com.farmmart.data.repository.appuser.AppUserRepository;
import com.farmmart.data.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Slf4j
@Sql(scripts ={"classpath:db/insert.sql"})
class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ProductRepository productRepository;

    Cart cart;
    AppUser appUser;
    Product product;

    @BeforeEach
    void setUp() {
        cart=new Cart();
        appUser=new AppUser();
        product=new Product();
    }

    @Test
    void testThatYouCanSaveCart() throws ProductNotFoundException {
        String username= "BukolaFako";

        appUser=appUserRepository.findByUserName(username);

        Long id =3L;
        product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product Id Not Found"));

        Integer orderQuantity=6;
        cart.setOrderQuantity(orderQuantity);
        cart.setProduct(product);
        cart.setAppUser(appUser);

        log.info("Cart repo before saving: {}", cart);

        assertDoesNotThrow(()->cartRepository.save(cart));

        assertEquals(orderQuantity,cart.getOrderQuantity());

        log.info("Cart repo after saving: {}", cart);
    }

    @Test
    void testThatYouCanFindCartById() throws CartNotFoundException {
        Long id =2L;

        cart=cartRepository.findById(id).orElseThrow(()->new CartNotFoundException("Cart Not Found"));

        log.info("Cart id 2:{}",cart);
    }

    @Test
    void testThatYouFindCartByUser(){

        String username="BukolaFako";

        appUser=appUserRepository.findByUserName(username);

        List<Cart> carts=cartRepository.findCartByAppUser(appUser);

        log.info("BukolaFako's Cart: {}",carts);
    }

    @Test
    void testThatYouCanFindAllCarts(){
        List<Cart> carts=cartRepository.findAll();

        log.info("All Carts: {}", carts);
    }

    @Test
    void testThatYouCanUpdateCart() throws CartNotFoundException {

        Long id=1L;

        cart=cartRepository.findById(id).orElseThrow(()->new CartNotFoundException("Cart Not Found"));

        Integer orderQuantity=10;
        cart.setOrderQuantity(orderQuantity);

        assertDoesNotThrow(()->cartRepository.save(cart));

        assertThat(cart.getOrderQuantity()).isEqualTo(orderQuantity);

        log.info("Cart new order quantity:{}",cart.getOrderQuantity());
    }

    @Test
    void testThatYouCanDeleteCartById(){
        Long id=2L;
        if (cartRepository.existsById(id))
            cartRepository.deleteById(id);

        Optional<Cart> optionalCart=cartRepository.findById(id);

        log.info("Cart: {}",optionalCart.get());//should fail
    }

    @Test
    void testThatYouCanDeleteAllCart(){
        cartRepository.deleteAll();
    }
}