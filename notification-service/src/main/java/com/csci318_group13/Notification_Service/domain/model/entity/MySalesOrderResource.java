package com.csci318_group13.Notification_Service.domain.model.entity;


import java.time.LocalDate;
import java.util.List;

/*
@Entity
@NamedQuery(name = "SalesOrder.findByPlacingOrderID" ,
        query = "select o from SalesOrder o where o.placingOrderID.placingId = ?1");

 */


public class MySalesOrderResource {

    private Long customerId ;
    private List<Long> productIds;
    private SalesOrderDate salesOrderDate ;

    private SalesOrderTotalAmount salesOrderTotalAmount ;

    public MySalesOrderResource() {
    }

    public MySalesOrderResource(Long customerId, List<Long> productIds, SalesOrderDate salesOrderDate, SalesOrderTotalAmount salesOrderTotalAmount) {
        this.customerId = customerId;
        this.productIds = productIds;
        this.salesOrderDate = salesOrderDate;
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }



    public Long getCustomerId() {
        return customerId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public SalesOrderDate getSalesOrderDate() {
        return salesOrderDate;
    }

    public SalesOrderTotalAmount getSalesOrderTotalAmount() {
        return salesOrderTotalAmount;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public void setSalesOrderDate(SalesOrderDate salesOrderDate) {
        this.salesOrderDate = salesOrderDate;
    }

    public void setSalesOrderTotalAmount(SalesOrderTotalAmount salesOrderTotalAmount) {
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "customerId=" + customerId +
                ", productIds=" + productIds +
                ", salesOrderDate=" + salesOrderDate +
                ", salesOrderTotalAmount=" + salesOrderTotalAmount +
                '}';
    }
}
