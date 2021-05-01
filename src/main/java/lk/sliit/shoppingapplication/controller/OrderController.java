package lk.sliit.shoppingapplication.controller;

import lk.sliit.shoppingapplication.model.OrderDetail;
import lk.sliit.shoppingapplication.model.OrderItem;
import lk.sliit.shoppingapplication.model.OrderRequest;
import lk.sliit.shoppingapplication.service.OrderItemService;
import lk.sliit.shoppingapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/place-order")
    public void add(@RequestBody OrderRequest orderRequest) {
        orderService.add(orderRequest.getOrderDetail());
        orderItemService.updateProductQtyAndSaveOrderItems(orderRequest.getOrderItems());
    }
}
