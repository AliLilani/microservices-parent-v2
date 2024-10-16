package com.csci318_group13.customer_Service.service;

import com.csci318_group13.customer_Service.domain.model.aggregate.Customer;
import com.csci318_group13.customer_Service.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }



    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public  Customer getCustomer(String id)  {

        Long longId =   Long.valueOf(id);


        return customerRepository.findById((longId)).orElseThrow();
    }


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerByID(String id) {
        Long longId =   Long.valueOf(id);
        customerRepository.deleteById(longId);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
