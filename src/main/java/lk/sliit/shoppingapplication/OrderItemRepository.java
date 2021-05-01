package lk.sliit.shoppingapplication;

import lk.sliit.shoppingapplication.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
