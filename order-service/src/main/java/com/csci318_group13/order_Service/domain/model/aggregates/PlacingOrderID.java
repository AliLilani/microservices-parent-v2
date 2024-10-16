package com.csci318_group13.order_Service.domain.model.aggregates;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class PlacingOrderID implements Serializable {
    private Long placingId ;

    public PlacingOrderID() {
    }

    public PlacingOrderID(Long placingId) {
        this.placingId = placingId;
    }

    public Long getPlacingId() {
        return placingId;
    }

    @Override
    public String toString() {
        return Long.toString(getPlacingId());
    }
}
