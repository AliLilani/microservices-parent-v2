package com.csci318_group13.Inventory_Service.events;

//import com.csci318_group13.order_Service.domain.model.aggregates.PlacingOrderID;

import java.io.Serializable;
import java.util.List;

public class OrderPlacedEventData implements Serializable {

    private  String placingOrderID ;
    private List<Long> productIds ;

    public OrderPlacedEventData(String placingOrderID , List<Long> productIds ) {
        this.placingOrderID = placingOrderID;
        this.productIds = productIds ;
    }
    public OrderPlacedEventData() {
    }


    public String getPlacingOrderID() {
        return placingOrderID;
    }

    public void setPlacingOrderID(String placingOrderID) {
        this.placingOrderID = placingOrderID;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "OrderPlacedEventData{" +
                "placingOrderID='" + placingOrderID + '\'' +
                ", productIds=" + productIds +
                '}';
    }
}
