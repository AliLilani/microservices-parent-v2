package com.csci318_group13.order_Service.domain.model.entities;

import jakarta.persistence.*;

@Entity
@Embeddable
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence" ,
            sequenceName = "product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
            generator = "product_sequence")
    Long productId ;
    private String name ;
    private String  description ;


    private double price ;

    public Product() {
    }

    public Product(String name, String description, int stockQuantity , double price) {
        this.name = name;
        this.description = description;

        this.price = price ;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
