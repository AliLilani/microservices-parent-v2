package com.csci318_group13.Notification_Service.application;



import com.csci318_group13.Notification_Service.application.outboundServices.rest.QueryCustomerService;
import com.csci318_group13.Notification_Service.application.outboundServices.rest.QueryOrderService;
import com.csci318_group13.Notification_Service.domain.model.entity.CustomerDTO;
import com.csci318_group13.Notification_Service.domain.model.entity.MySalesOrderResource;
import com.csci318_group13.Notification_Service.events.OrderApprovalStatusData;
import com.csci318_group13.Notification_Service.events.OrderApprovalStatusEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.function.Consumer;

@Service
public class OrderApprovedEventHandler {
    private static final Logger log = LoggerFactory.getLogger(OrderApprovedEventHandler.class);
    private final RestTemplate restTemplate;

    private QueryOrderService queryOrderService ;
    private QueryCustomerService queryCustomerService ;




    public OrderApprovedEventHandler(RestTemplate restTemplate,
                                        QueryOrderService queryOrderService ,QueryCustomerService queryCustomerService ) {
        this.restTemplate = restTemplate;


        this.queryOrderService = queryOrderService ;
        this.queryCustomerService = queryCustomerService ;
    }

    @Bean
    public Consumer<OrderApprovalStatusEvent> consume() {
        // System.out.println("receiving from  kafka");


        

        return event -> {
            try {

                log.info("Notification service Received event: " + event);

                // Access the OrderPlacedEventData object from the event
                OrderApprovalStatusData eventData = event.getOrderApprovalStatusData();

                // Now you can use the data from the event
                String placingOrderID = eventData.getPlacingOrderID();
               boolean approvalStatus = eventData.getApproved() ;
                System.out.println(  " oeder no :" +placingOrderID + "  approvalStatus is "  + approvalStatus);

               MySalesOrderResource mySalesOrderResource =  queryOrderService.findOrder(placingOrderID) ;
               // then from here ask customer microservice for a customer using customerid in order above

                CustomerDTO customerDTO = queryCustomerService.findCustomerByID(mySalesOrderResource.getCustomerId());

                // then send emai to customer telling him whether order approved or disapproved

                sendEmailToCustomer(customerDTO.getContactInfo().getEmail() ,
                       eventData.getApproved() , placingOrderID);



            } catch (Exception e) {
                log.error("Failed to process the event", e);
            }
        };
    }


private void sendEmailToCustomer( String email , Boolean approvalStatus , String placingOrderId) {

        //  we simulate here sending email to customer
        // in real application , it needs email user and password to send an email and
        // add some dependency in pom file
        log.info("Sending EMAIL TO CUSTOMER .....");
        log.info("EMAIL : " +  email);
        log.info("Dear customer we would like to notify you that your order  " + placingOrderId );
        if (approvalStatus ) {
            log.info("has been approved and will be sent to you");

        }else {
            log.info("has not been been approved ");

        }

}
}



