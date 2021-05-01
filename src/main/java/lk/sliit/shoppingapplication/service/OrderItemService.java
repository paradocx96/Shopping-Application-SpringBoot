package lk.sliit.shoppingapplication.service;

import lk.sliit.shoppingapplication.OrderItemRepository;
import lk.sliit.shoppingapplication.ProductRepository;
import lk.sliit.shoppingapplication.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public void updateProductQtyAndSaveOrderItems(OrderItem[] orderItems) {
        for (OrderItem orderItem : orderItems) {

        }
    }
}
