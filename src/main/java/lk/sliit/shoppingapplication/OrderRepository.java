package lk.sliit.shoppingapplication;

import lk.sliit.shoppingapplication.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetail, String> {
}
