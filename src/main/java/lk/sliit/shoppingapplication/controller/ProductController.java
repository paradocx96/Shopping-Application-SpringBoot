package lk.sliit.shoppingapplication.controller;

import lk.sliit.shoppingapplication.model.Product;
import lk.sliit.shoppingapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add-product")
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @GetMapping("/delete-product/{id}")
    public void delete(@PathVariable("id") String id) {
        productService.delete(id);
    }

    @GetMapping("/get-all-product")
    public List<Product> list() {
        return productService.listAll();
    }

    @PutMapping("/update-product")
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

}
