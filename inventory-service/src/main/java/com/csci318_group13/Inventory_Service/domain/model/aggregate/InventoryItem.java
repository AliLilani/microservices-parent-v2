package com.csci318_group13.Inventory_Service.domain.model.aggregate;

import com.csci318_group13.Inventory_Service.domain.model.commands.AddInventoryItemCommand;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Expiry;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Location;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Stock;
import jakarta.persistence.*;

@Entity
@NamedQuery(name = "InventoryItem.findByProductId" ,
query =  "Select i from InventoryItem i where i.productId =?1")
@NamedQuery(name = "InventoryItem.findItemsBelowStockLevel" ,
        query =  "Select i from InventoryItem i where i.stock.stockQuantity <?1")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;  // Value object representing the product this inventory item tracks

    @Embedded
    private Location location;  // Value object containing location details

    @Embedded
    private Stock stock;  // Value object representing available stock

    @Embedded
    private Expiry expiry ;

    // Constructors, Getters, and Setters


    public InventoryItem() {
    }

    public InventoryItem(Long id, Long productId, Location location, Stock stock, Expiry expiry) {
        this.id = id;
        this.productId = productId;
        this.location = location;
        this.stock = stock;
        this.expiry = expiry;
    }
/// contiue from here
    public InventoryItem(AddInventoryItemCommand addInventoryItemCommand) {
        this.productId = addInventoryItemCommand.getProductId();
        this.location = addInventoryItemCommand.getLocation() ;
        this.stock = addInventoryItemCommand.getStock();
        this.expiry = addInventoryItemCommand.getExpiryDate() ;
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

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Location getLocation() {
        return location;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public void setExpiry(Expiry expiry) {
        this.expiry = expiry;
    }

    public Stock getStock() {
        return stock;
    }
}
