package com.csci318_group13.customer_Service.interfaces;

import com.csci318_group13.customer_Service.DTO.CustomerDTO;
import com.csci318_group13.customer_Service.domain.model.aggregate.Customer;
import com.csci318_group13.customer_Service.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {


    private final CustomerService customerService;

   CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customer/allCustomers")
    List<CustomerDTO> customerServiceallCustomers() {

        return customerService.getAllCustomers()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setlName(  customer.getlName());
                    customerDTO.setfName(customer.getfName());

                    customerDTO.setId(customer.getId());
                    customerDTO.setContactInfo(customer.getContactInfo());

                    return customerDTO;
                }).collect(Collectors.toList());
    }

    @GetMapping("/api/customers/{id}")
    CustomerDTO findCustomer(@PathVariable String id){

        Customer customer = customerService.getCustomer(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setlName(  customer.getlName());
        customerDTO.setfName(customer.getfName());
        customerDTO.setContactInfo(customer.getContactInfo());
        customerDTO.setId(customer.getId());

        return customerDTO;
    }


    @PostMapping("/api/customer/addCustomer")
    Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
       Customer c = new Customer();
       c.setfName(customerDTO.getfName());
        c.setlName(customerDTO.getlName());

        c.setContactInfo(customerDTO.getContactInfo());




        return customerService.saveCustomer(c);
    }

    @PutMapping("/api/customer/update/{id}")
    Customer updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable String id) {
      Customer customer = customerService.getCustomer(id);
      customer.setfName(customerDTO.getfName());
        customer.setlName(customerDTO.getlName());
        customer.setContactInfo(customerDTO.getContactInfo());
        customerService.updateCustomer(customer) ;

        return customer ;

    }

    @DeleteMapping("/customer/delete/{id}")
    void deleteEmployee(@PathVariable String id) {
        customerService.deleteCustomerByID(id);
    }


}
