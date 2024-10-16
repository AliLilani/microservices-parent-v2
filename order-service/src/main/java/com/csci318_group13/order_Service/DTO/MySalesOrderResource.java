package com.csci318_group13.order_Service.DTO;

import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderDate;
import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderTotalAmount;

import java.util.List;

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
}
