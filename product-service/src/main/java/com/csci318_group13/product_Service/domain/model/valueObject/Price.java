package com.csci318_group13.product_Service.domain.model.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Price  implements Serializable {
    @Column
    private Integer amount;

    public Price(Integer value) {
        this.amount = value;
    }

    public Price() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + amount +
                '}';
    }
}
