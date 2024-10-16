package com.csci318_group13.customer_Service.repository;

import com.csci318_group13.customer_Service.domain.model.aggregate.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
         {
}