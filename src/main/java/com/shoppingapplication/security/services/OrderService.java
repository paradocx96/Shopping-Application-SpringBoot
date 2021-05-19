package com.shoppingapplication.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapplication.models.OrderDetail;
import com.shoppingapplication.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void add(OrderDetail orderDetail) {
        orderRepository.save(orderDetail);
    }
}
