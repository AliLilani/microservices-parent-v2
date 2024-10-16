package com.csci318_group13.Notification_Service.application.outboundServices.rest;

import com.csci318_group13.Notification_Service.domain.model.entity.MySalesOrderResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QueryOrderService {
    private static final Logger log = LoggerFactory.getLogger(QueryOrderService.class);

    private final RestTemplate restTemplate;

    public QueryOrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MySalesOrderResource findOrder(String placingOrderID) {

        String orderServiceUrl = "http://localhost:8081/api/orders/placingID/"  ;

        try {
            log.info(orderServiceUrl + placingOrderID);
            //String  url = "http://localhost:8081/api/orders/placingID/1857293163204658324";

               ResponseEntity<MySalesOrderResource> SalesOrderResourceDTOResponse  = restTemplate.getForEntity(orderServiceUrl + placingOrderID, MySalesOrderResource.class);
           // ResponseEntity<MySalesOrderResource> SalesOrderResourceDTOResponse  = restTemplate.getForEntity(url, MySalesOrderResource.class);

            if (SalesOrderResourceDTOResponse.getStatusCode() == HttpStatus.OK) {

                    MySalesOrderResource o = SalesOrderResourceDTOResponse.getBody();

                    log.info("order with ID" + placingOrderID + " exist and its cutomer id is  :" + o.getCustomerId() );
                    return  o ;


                } else {

                    log.info("product with ID  " + placingOrderID + "does not exist in order service");
                    return  null ;
                }


        } catch (Exception e) {
            log.error(e.toString());
            return  null ;
        }



    }
}
