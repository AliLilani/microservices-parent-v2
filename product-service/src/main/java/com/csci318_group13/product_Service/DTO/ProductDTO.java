package com.csci318_group13.product_Service.DTO;

import com.csci318_group13.product_Service.domain.model.entity.Vendor;
import com.csci318_group13.product_Service.domain.model.valueObject.Price;

import java.util.Objects;

public class ProductDTO {

    private String name ;
    private String  description ;


    private Price price ;
    private Vendor vendor ;

    Long id ;

    public Long getId() {
        return id;
    }

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, Price price , Long id ,Vendor vendor) {
        this.name = name;
        this.description = description;

        this.price = price;
        this.id = id ;
        this.vendor = vendor ;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setPrice(Price price) {
        this.price = price;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vendor=" + vendor +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
