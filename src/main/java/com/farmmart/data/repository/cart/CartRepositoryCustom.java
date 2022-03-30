package com.farmmart.data.repository.cart;

import com.farmmart.data.model.appuser.AppUser;
import com.farmmart.data.model.cart.Cart;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepositoryCustom {

    @Query("From Cart c Where c.appUser=?1")
    List<Cart> findCartByAppUser(AppUser appUser);
}
