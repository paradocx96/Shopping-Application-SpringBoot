package com.shoppingapplication.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapplication.models.OrderDetail;

public interface OrderRepository extends JpaRepository<OrderDetail, String> {
}
