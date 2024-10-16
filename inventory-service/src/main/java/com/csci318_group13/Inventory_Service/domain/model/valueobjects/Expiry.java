package com.csci318_group13.Inventory_Service.domain.model.valueobjects;



import jakarta.persistence.Embeddable;

import java.time.LocalDate;
@Embeddable
public class Expiry {
    private LocalDate expiryDate ;

    public Expiry() {
    }

    public Expiry(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Expiry{" +
                "expiryDate=" + expiryDate +
                '}';
    }
}
