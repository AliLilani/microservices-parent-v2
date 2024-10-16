package com.csci318_group13.Inventory_Service.domain.model.entities;


import jakarta.persistence.Embedded;

public class Product {

    Long id ;
    private String name ;
    private String  description ;

    @Embedded
    private Price price ;
    @Embedded
    private Vendor vendor ;

    public Product(Long id, String name, String description, Price price, Vendor vendor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendor = vendor;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vendor=" + vendor +
                '}';
    }
}