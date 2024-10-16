package com.csci318_group13.order_Service.application.outboundservices;

import com.csci318_group13.order_Service.events.OrderPlacedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class SalesOrderPlacingPublisherService {
    private final StreamBridge streamBridge ;
    private static final Logger log = LoggerFactory.getLogger(SalesOrderPlacingPublisherService.class);


    public SalesOrderPlacingPublisherService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }
    @TransactionalEventListener
    public void handleOrderInitiatedEvent(OrderPlacedEvent orderPlacedEvent) {

        System.out.println("sending to kafka");
        System.out.println(orderPlacedEvent.getOrderPlacedEventData().getProductIds());

       // streamBridge.send("orderPlacedChannel" , orderPlacedEvent);


        log.info("Sending event to Kafka: " + orderPlacedEvent);
        boolean result = streamBridge.send("orderPlacedChannel", orderPlacedEvent);
        log.info("Event sent: " + result);

    }

    /*
     we did not construct yet the OrderApprovedEvent
    this will be published upon recieving from Inventory microservice that the orderapproved
    then we may send notification to the customer service or may be to future payment service
    @TransactionalEventListener
    public void handleOrderApproved(OrderApprovedEvent orderApprovedEvent) {
        streamBridge.send("orderApprovedChannel" , orderPlacedEvent);
    }

     */
}
