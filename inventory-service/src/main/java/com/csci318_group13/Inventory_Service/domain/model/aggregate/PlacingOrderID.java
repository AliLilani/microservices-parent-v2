package com.csci318_group13.Inventory_Service.domain.model.aggregate;

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
