package com.farmmart.data.repository.orderdetail;

import com.farmmart.data.model.order.CustomerOrder;
import com.farmmart.data.model.orderitem.OrderItem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepositoryCustom {

    @Query("From OrderItem o Where o.customerOder=?1")
    List<OrderItem> findOrderItemsByOrderId(CustomerOrder customerOrder);
}
