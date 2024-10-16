package com.csci318_group13.Inventory_Service.application.outboundservices;

import com.csci318_group13.Inventory_Service.events.OrderApprovalStatusEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryApprovalPublishingService {
    private final StreamBridge streamBridge ;
    private static final Logger log = LoggerFactory.getLogger(InventoryApprovalPublishingService.class);

    public InventoryApprovalPublishingService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @EventListener
    public void handleOrderInitiatedEvent(OrderApprovalStatusEvent orderApprovalStatusEvent) {

        System.out.println("sending to kafka by inventory service");
       // System.out.println(orderApprovalStatusEvent.

        // streamBridge.send("orderPlacedChannel" , orderPlacedEvent);


        log.info("Sending event to Kafka: " + orderApprovalStatusEvent);
        boolean result = streamBridge.send("orderApprovedChannel", orderApprovalStatusEvent);
        log.info("Event sent: " + result);

    }
}
