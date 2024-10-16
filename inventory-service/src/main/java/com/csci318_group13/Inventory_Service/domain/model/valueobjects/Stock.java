package com.csci318_group13.Inventory_Service.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Stock {
    private Integer stockQuantity;

    public Stock(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Stock() {
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
