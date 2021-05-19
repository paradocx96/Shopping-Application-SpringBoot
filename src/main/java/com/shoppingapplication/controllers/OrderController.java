package com.shoppingapplication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapplication.models.OrderRequest;
import com.shoppingapplication.security.services.OrderItemService;
import com.shoppingapplication.security.services.OrderService;

import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product/buyer")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/place-order")
    //@PreAuthorize("hasRole('BUYER')")
    public void add(@RequestBody OrderRequest orderRequest) {
        orderService.add(orderRequest.getOrderDetail());
        orderItemService.updateProductQtyAndSaveOrderItems(orderRequest.getOrderItems());
    }
}
