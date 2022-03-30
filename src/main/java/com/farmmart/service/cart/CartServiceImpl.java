package com.farmmart.service.cart;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.cart.Cart;
import com.farmmart.data.model.cart.CartDto;
import com.farmmart.data.model.cart.CartItemDto;
import com.farmmart.data.model.cart.CartNotFoundException;
import com.farmmart.data.repository.appuser.AppUserRepository;
import com.farmmart.data.repository.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@Transactional
public class CartServiceImpl implements CartService{


        @Autowired
        private CartRepository cartRepository;

        @Autowired
        private AppUserRepository appUserRepository;

        @Override
        public Cart addToCart(Cart newCart) {

            return cartRepository.save(newCart);
        }

        @Override
        public Cart findCartById(Long id) {
            Cart cart=cartRepository.findById(id).orElseThrow();

            return cart;
        }

        @Override
        public CartDto listCartItems(AppUser appUser,String username) {

            appUser=appUserRepository.findByUserName(username);

            List<Cart> carts=cartRepository.findCartByAppUser(appUser);

            List<CartItemDto> cartItemDtos= new ArrayList<>();

            for (Cart cart:carts){

                CartItemDto cartItemDto = getDtoFromCart(cart);

                cartItemDtos.add(cartItemDto);
            }

            BigDecimal totalCost = BigDecimal.ZERO;

            for (CartItemDto cartItemDto :cartItemDtos){

                totalCost =totalCost.add(cartItemDto.getPrice().multiply(new BigDecimal( cartItemDto.getOrderQuantity())));
            }

            return new CartDto(cartItemDtos,totalCost);
        }

        @Override
        public Cart updateCart(Cart cart, Long id) throws CartNotFoundException {

            Cart savedCart=cartRepository.findById(id).orElseThrow(()->new CartNotFoundException("Cart Not Found"));

            if (Objects.nonNull(cart.getOrderQuantity())){

                savedCart.setOrderQuantity(cart.getOrderQuantity());
            }

            return cartRepository.save(savedCart);
        }

        @Override
        public List<Cart> findAllCarts() {
            return cartRepository.findAll();
        }

        @Override
        public void deleteCartById(Long id) throws CartNotFoundException {

            cartRepository.deleteById(id);

            Optional<Cart> optionalCart=cartRepository.findById(id);

            if (optionalCart.isPresent()){

                throw new CartNotFoundException("Cart id "+id+" is not deleted");
            }
        }

        @Override
        public void deleteAllCarts() {

            cartRepository.deleteAll();
        }

        private static CartItemDto getDtoFromCart(Cart cart) {
            return new CartItemDto(cart);
        }

}
