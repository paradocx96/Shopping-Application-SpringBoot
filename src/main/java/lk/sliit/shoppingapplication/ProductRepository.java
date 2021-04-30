package lk.sliit.shoppingapplication;

import lk.sliit.shoppingapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
