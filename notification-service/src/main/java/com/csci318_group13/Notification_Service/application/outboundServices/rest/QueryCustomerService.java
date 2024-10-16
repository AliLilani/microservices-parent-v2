package com.csci318_group13.Notification_Service.application.outboundServices.rest;

import com.csci318_group13.Notification_Service.domain.model.entity.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class QueryCustomerService {

    private static final Logger log = LoggerFactory.getLogger(QueryOrderService.class);

    private final RestTemplate restTemplate;


    public QueryCustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CustomerDTO findCustomerByID(Long customerId) {

        String customerServiceUrl = "http://localhost:8084/api/customers/"  ;

        try {

            ResponseEntity<CustomerDTO> customerDTOResponse  = restTemplate.getForEntity(customerServiceUrl + customerId, CustomerDTO.class);
            if (customerDTOResponse.getStatusCode() == HttpStatus.OK) {

                CustomerDTO customerDTO = customerDTOResponse.getBody();

                log.info("customer detail is :"  + customerDTO.toString()  );


                return  customerDTO;


            } else {

                log.info("can not locate customer ID in customer micro service");
                return  null ;
            }


        } catch (Exception e) {
            log.error("can not locate customer ID in customer micro service");
            return  null ;
        }



    }


    }

