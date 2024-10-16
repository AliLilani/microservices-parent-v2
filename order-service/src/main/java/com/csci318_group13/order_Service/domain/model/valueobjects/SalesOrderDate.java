package com.csci318_group13.order_Service.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;
@Embeddable


public class SalesOrderDate {
    @Column(name = "salesOrder_localDate" , unique =false , updatable = false)

    private LocalDate orderDate;

    public SalesOrderDate() {
    }

    public SalesOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
