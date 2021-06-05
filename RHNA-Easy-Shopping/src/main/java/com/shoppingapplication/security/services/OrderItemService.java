package com.shoppingapplication.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapplication.models.OrderItem;
import com.shoppingapplication.models.Product;
import com.shoppingapplication.repositories.OrderItemRepository;
import com.shoppingapplication.repositories.ProductRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public void updateProductQtyAndSaveOrderItems(OrderItem[] orderItems) {
        for (OrderItem orderItem : orderItems) {
            Product product = productRepository.findById(orderItem.getProductId()).get();
            int newQuantity = product.getStockQty() - orderItem.getQuantity();
            product.setStockQty(newQuantity);
            productRepository.save(product);
            orderItemRepository.save(orderItem);
        }
    }
}
