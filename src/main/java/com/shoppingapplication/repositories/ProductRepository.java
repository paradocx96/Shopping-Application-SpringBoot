package com.shoppingapplication.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapplication.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
