package com.shoppingapplication.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapplication.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
