package com.csci318_group13.Inventory_Service.interfaces.rest.dto;

import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Location;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Stock;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Expiry;

public class InventoryResource {


    private Long productId;
    private Location location;


    private Stock stock;
    private Expiry expiryDate ;



    public InventoryResource(Long productId, Location location, Stock stock, Expiry expiryDate) {
        this.productId = productId;
        this.location = location;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    public InventoryResource() {}

    public Long getProductId() {
        return productId;
    }

    public Location getLocation() {
        return location;
    }

    public Stock getStock() {
        return stock;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Expiry getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Expiry expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "InventoryResource{" +
                "productId=" + productId +
                ", location=" + location +
                ", stock=" + stock +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
