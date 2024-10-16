package com.csci318_group13.product_Service.domain.model.aggregate;

import com.csci318_group13.product_Service.domain.model.entity.Vendor;
import com.csci318_group13.product_Service.domain.model.valueObject.Price;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "PRODUCT")
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence" ,
            sequenceName = "product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
            generator = "product_sequence")
    Long id ;
    private String name ;
    private String  description ;

    @Embedded
    private Price price ;
    @Embedded
    private Vendor vendor ;





    public Product(String name, String description , Price price ,Vendor vendor) {
        this.name = name;
        this.description = description;

        this.price = price ;
        this.vendor = vendor ;
    }

    public Product() {
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
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



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vendor getVendor() {
        return vendor;
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
