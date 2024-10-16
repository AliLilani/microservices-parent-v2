package com.csci318_group13.product_Service.Repository;

import com.csci318_group13.product_Service.domain.model.aggregate.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
