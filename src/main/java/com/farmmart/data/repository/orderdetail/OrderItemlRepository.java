package com.farmmart.data.repository.orderdetail;

import com.farmmart.data.model.orderitem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemlRepository extends JpaRepository<OrderItem,Long> {
}
