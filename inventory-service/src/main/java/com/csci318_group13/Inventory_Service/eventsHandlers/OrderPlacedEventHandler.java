package com.csci318_group13.Inventory_Service.eventsHandlers;


import com.csci318_group13.Inventory_Service.application.queryservices.InventoryQueryService;
import com.csci318_group13.Inventory_Service.events.OrderApprovalStatusData;
import com.csci318_group13.Inventory_Service.events.OrderApprovalStatusEvent;
import com.csci318_group13.Inventory_Service.events.OrderPlacedEvent;
import com.csci318_group13.Inventory_Service.events.OrderPlacedEventData;
import com.csci318_group13.Inventory_Service.application.outboundservices.rest.ProductServiceCheckingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.function.Consumer;

@Service
public class OrderPlacedEventHandler {
    private static final Logger log = LoggerFactory.getLogger(OrderPlacedEventHandler.class);
    private final RestTemplate restTemplate;
    private final ProductServiceCheckingService productServiceCheckingService;
    private final ApplicationEventPublisher applicationEventPublisher ;
    private InventoryQueryService inventoryQueryService ;


    public OrderPlacedEventHandler(RestTemplate restTemplate, ProductServiceCheckingService productServiceCheckingService,
                                   InventoryQueryService inventoryQueryService , ApplicationEventPublisher applicationEventPublisher) {
        this.restTemplate = restTemplate;
        this.productServiceCheckingService = productServiceCheckingService;
        this.inventoryQueryService = inventoryQueryService;
        this.applicationEventPublisher = applicationEventPublisher ;
    }

    @Bean
    public Consumer<OrderPlacedEvent> consume() {
        // System.out.println("receiving from  kafka");



        return event -> {
            try {

                log.info("Received event: " + event);

                // Access the OrderPlacedEventData object from the event
                OrderPlacedEventData eventData = event.getOrderPlacedEventData();


                String placingOrderID = eventData.getPlacingOrderID();
                List<Long> productIds = eventData.getProductIds();
                System.out.println(productIds);



                processOrder(placingOrderID, productIds );

            } catch (Exception e) {
                log.error("Failed to process the event", e);
            }
        };
    }


    private void processOrder(String placingOrderID, List<Long> productIds ) {


        log.info("Processing order with ID: " + placingOrderID);

           // first check that productIds in order are consistent with Product id in Productmicroservice
       if  (productServiceCheckingService.CheckProductsExixt(productIds)) {
           // check that all items in order are available and not expired
           if ( inventoryQueryService.isAvailable(productIds) && !inventoryQueryService.isExpired(productIds)  ) {

               // initiate approved order here  and modify the stock quantity in inventory here
               OrderApprovalStatusEvent orderApprovalStatusEvent = new OrderApprovalStatusEvent(
                       new OrderApprovalStatusData(true ,placingOrderID)
               ) ;
              // applicationEventPublisher.publishEvent(orderApprovalStatusEvent);

               handleEvent(orderApprovalStatusEvent);
               log.info("sending to kafka from inventory");
              inventoryQueryService.updateInventoryItemsStock(productIds  );
           }
           else {


               log.info("at least on item in order number: " + placingOrderID + " is expired or not available in inventory");
               // initiate disaproveorder event here because of expiry date

              OrderApprovalStatusEvent orderApprovalStatusEvent = new OrderApprovalStatusEvent(
                       new OrderApprovalStatusData(false ,placingOrderID)) ;

               log.info("sending to kafka from inventory");
               handleEvent(orderApprovalStatusEvent);


           }
       }
       else { ////  add here for product not exist in product microservice
           // initiate disapproveorderevent here because productid not existing in productservice
           OrderApprovalStatusEvent orderApprovalStatusEvent = new OrderApprovalStatusEvent(
                   new OrderApprovalStatusData(false ,placingOrderID)) ;
           handleEvent(orderApprovalStatusEvent);

       }



    }

    @Async
    public void handleEvent(OrderApprovalStatusEvent orderApprovalStatusEvent) {
        applicationEventPublisher.publishEvent(orderApprovalStatusEvent);

    }

}




