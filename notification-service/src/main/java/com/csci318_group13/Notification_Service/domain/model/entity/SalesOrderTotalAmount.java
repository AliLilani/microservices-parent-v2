package com.csci318_group13.Notification_Service.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable

public class SalesOrderTotalAmount {

    @Column (name = "salesOrder_totalAmount" , unique =false , updatable = false)
    private double salesOrderTotalAmount ;

    public SalesOrderTotalAmount() {
    }

    public SalesOrderTotalAmount(double salesOrderTotalAmount) {
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }

    public double getSalesOrderTotalAmount() {
        return salesOrderTotalAmount;
    }

    public void setSalesOrderTotalAmount(double salesOrderTotalAmount) {
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }
}
