package com.csci318_group13.customer_Service.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence" ,
            sequenceName = "product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
            generator = "product_sequence")
    Long id ;
    private String name ;
    private String  description ;
    private int stockQuantity ;

    private double price ;

    public Product() {
    }

    public Product(String name, String description, int stockQuantity , double price) {
        this.name = name;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.price = price ;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", price=" + price +
                '}';
    }
}
