package lk.sliit.shoppingapplication.service;

import lk.sliit.shoppingapplication.ProductRepository;
import lk.sliit.shoppingapplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void add(Product product) {
        productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public void update(Product product) {
        productRepository.save(product);
    }
}
