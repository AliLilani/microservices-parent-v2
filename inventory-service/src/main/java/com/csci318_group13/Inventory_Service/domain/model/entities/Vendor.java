package com.csci318_group13.Inventory_Service.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Vendor implements Serializable {
    @Column
    private String vendorName ;

    public Vendor() {
    }

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorName='" + vendorName + '\'' +
                '}';
    }
}
