package com.csci318_group13.Inventory_Service.domain.model.commands;

import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Expiry;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Location;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Stock;

public class AddInventoryItemCommand {

    private Long productId;
    private Location location;


    private Stock stock;
    private Expiry expiryDate ;

    public AddInventoryItemCommand() {
    }


    public AddInventoryItemCommand(Long productId, Location location, Stock stock, Expiry expiryDate) {
        this.productId = productId;
        this.location = location;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    public Expiry getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Expiry expiryDate) {
        this.expiryDate = expiryDate;
    }

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
}
