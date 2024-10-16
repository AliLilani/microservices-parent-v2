package com.csci318_group13.Inventory_Service.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
    private String warehouse;
    private String aisle;
    private String shelf;

    // Constructors, Getters, and Setters


    public Location() {
    }

    public String getWarehouse() {
        return warehouse;
    }

    public String getAisle() {
        return aisle;
    }

    public String getShelf() {
        return shelf;
    }

    public Location(String warehouse, String aisle, String shelf) {
        this.warehouse = warehouse;
        this.aisle = aisle;
        this.shelf = shelf;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Location{" +
                "warehouse='" + warehouse + '\'' +
                ", aisle='" + aisle + '\'' +
                ", shelf='" + shelf + '\'' +
                '}';
    }
}
