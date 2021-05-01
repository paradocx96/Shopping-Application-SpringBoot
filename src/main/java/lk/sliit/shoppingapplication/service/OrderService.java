package lk.sliit.shoppingapplication.service;

import lk.sliit.shoppingapplication.OrderRepository;
import lk.sliit.shoppingapplication.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void add(OrderDetail orderDetail) {
        orderRepository.save(orderDetail);
    }
}
