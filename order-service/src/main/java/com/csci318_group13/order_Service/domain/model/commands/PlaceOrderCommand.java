package com.csci318_group13.order_Service.domain.model.commands;

import com.csci318_group13.order_Service.domain.model.aggregates.PlacingOrderID;
import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderDate;
import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderTotalAmount;

import java.util.List;

public class PlaceOrderCommand {

    /*
     this.placingOrderID = placeOrderCommand.getOrder_id();
        this.salesOrderDate = placeOrderCommand.getOrderDate();
        this.customerId = placeOrderCommand.getCustomerId();
        this.productsId = placeOrderCommand.getProductsId();
     */

    private PlacingOrderID placingOrderID;

    private Long customerId ;
      private List<Long> productIds;
      private SalesOrderDate salesOrderDate ;


    private SalesOrderTotalAmount salesOrderTotalAmount ;


    public PlaceOrderCommand( Long customerId, List<Long> productIds, SalesOrderDate salesOrderDate, SalesOrderTotalAmount salesOrderTotalAmount) {

        this.customerId = customerId;
        this.productIds = productIds;
        this.salesOrderDate = salesOrderDate;
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }

    public PlaceOrderCommand() {
    }



    public PlacingOrderID getPlacingOrderID() {
        return placingOrderID;
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



    public void setPlacingOrderID(PlacingOrderID placingOrderID) {
        this.placingOrderID = placingOrderID;
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
    public SalesOrderTotalAmount getSalesOrderTotalAmount() {
        return salesOrderTotalAmount;
    }

    public void setSalesOrderTotalAmount(SalesOrderTotalAmount salesOrderTotalAmount) {
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }
}
