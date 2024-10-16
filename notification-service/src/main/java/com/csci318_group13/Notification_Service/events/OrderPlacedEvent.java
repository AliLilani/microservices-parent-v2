package com.csci318_group13.Notification_Service.events;

import java.io.Serializable;

public class OrderPlacedEvent implements Serializable {
    OrderPlacedEventData orderPlacedEventData  ;

    public OrderPlacedEvent() {
    }

    public OrderPlacedEvent(OrderPlacedEventData orderPlacedEventData) {
        this.orderPlacedEventData = orderPlacedEventData;
    }

    public void setOrderPlacedEventData(OrderPlacedEventData orderPlacedEventData) {
        this.orderPlacedEventData = orderPlacedEventData;
    }

    public OrderPlacedEventData getOrderPlacedEventData() {
        return orderPlacedEventData;
    }

    @Override
    public String toString() {
        return "OrderPlacedEvent{" +
                "orderPlacedEventData=" + orderPlacedEventData +
                '}';
    }
}
