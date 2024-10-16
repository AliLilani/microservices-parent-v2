package com.csci318_group13.Inventory_Service.application.outboundservices.rest;


import com.csci318_group13.Inventory_Service.domain.model.entities.Product;
import com.csci318_group13.Inventory_Service.eventsHandlers.OrderPlacedEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class ProductServiceCheckingService {
    private static final Logger log = LoggerFactory.getLogger(OrderPlacedEventHandler.class);

    private final RestTemplate restTemplate;

    public ProductServiceCheckingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean CheckProductsExixt(List<Long> productIds) {

        String productServiceUrl = "http://localhost:8083/api/products/";

        try {
            for (Long productId : productIds) {
                ResponseEntity<Product> productResponse = restTemplate.getForEntity(productServiceUrl + productId, Product.class);
                if (productResponse.getStatusCode() == HttpStatus.OK) {

                    Product p = productResponse.getBody();

                    log.info("product with ID" + productId + " exist and its name :" + p.getName() + "  and its description : " + p.getDescription());


                } else {

                    log.info("product with ID  " + productId + "does not exist in product service");
                    return false ;
                }
            }

        } catch (Exception e) {
            log.error("at least one item in order does not exist in product microservice");
            return false ;
        }
        return true ;


    }
}
