package lk.sliit.shoppingapplication.service;

import lk.sliit.shoppingapplication.OrderItemRepository;
import lk.sliit.shoppingapplication.ProductRepository;
import lk.sliit.shoppingapplication.model.OrderItem;
import lk.sliit.shoppingapplication.model.Product;
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
            Product product = productRepository.findById(orderItem.getProductId()).get();
            int newQuantity = product.getStockQty() - orderItem.getQuantity();
            product.setStockQty(newQuantity);
            productRepository.save(product);
            orderItemRepository.save(orderItem);
        }
    }
}
