package com.csci318_group13.order_Service.repository;

import com.csci318_group13.order_Service.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
