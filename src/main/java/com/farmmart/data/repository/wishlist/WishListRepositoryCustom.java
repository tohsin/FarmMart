package com.farmmart.data.repository.wishlist;

import com.farmmart.data.model.customer.Customer;
import com.farmmart.data.model.wishlist.WishList;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishListRepositoryCustom {

    @Query("From WishList w Where w.customer=?1")
    List<WishList> findWishListByCustomerId(Customer customer);

}
