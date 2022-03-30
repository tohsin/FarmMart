package com.farmmart.data.repository.wishlist;

import com.farmmart.data.model.wishlist.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList,Long> {
}
