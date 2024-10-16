package com.csci318_group13.order_Service.domain.model.aggregates;

import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderDate;
import com.csci318_group13.order_Service.domain.model.valueobjects.SalesOrderTotalAmount;
import com.csci318_group13.order_Service.domain.model.commands.PlaceOrderCommand;
import com.csci318_group13.order_Service.events.OrderPlacedEvent;
import com.csci318_group13.order_Service.events.OrderPlacedEventData;
import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.List;

/*
@Entity
@NamedQuery(name = "SalesOrder.findByPlacingOrderID" ,
        query = "select o from SalesOrder o where o.placingOrderID.placingId = ?1");

 */
@Entity
@NamedQuery(name = "SalesOrder.findByPlacingOrderID" ,
        query =  "Select s from SalesOrder s where s.placingOrderID.placingId =?1")
@NamedQuery(name = "SalesOrder.findAllOrdersByCUstomerID" ,
        query =  "Select s from SalesOrder s where s.customerId =?1")
@NamedQuery(name = "SalesOrder.findAllOrdersExceedingAmount" ,
        query =  "Select s from SalesOrder s where s.salesOrderTotalAmount.salesOrderTotalAmount >?1")

public class SalesOrder extends AbstractAggregateRoot<SalesOrder>  {
    @Id
    @SequenceGenerator(name = "order_sequence" ,
            sequenceName = "order_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
            generator = "order_sequence")
    Long orderId ;

    public Long getOrderId() {
        return orderId;
    }

    @Embedded
    private PlacingOrderID placingOrderID;
    @Embedded
    private SalesOrderTotalAmount salesOrderTotalAmount ;
@Embedded
    private SalesOrderDate salesOrderDate;


    @ElementCollection
    @CollectionTable(name = "order_product_ids", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    private List<Long> productIds;  // List of product IDs


    private Long customerId;


    public SalesOrder(Long customerId, SalesOrderDate salesOrderDate, List<Long> productIds) {
        this.customerId = customerId;
        this.salesOrderDate = salesOrderDate;
        this.productIds = productIds;
    }

    public SalesOrder() {
    }

    public PlacingOrderID getPlacingOrderID() {
        return placingOrderID;
    }

    public SalesOrderTotalAmount getSalesOrderTotalAmount() {
        return salesOrderTotalAmount;
    }

    public SalesOrderDate getSalesOrderDate() {
        return salesOrderDate;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setPlacingOrderID(PlacingOrderID placingOrderID) {
        this.placingOrderID = placingOrderID;
    }

    public void setSalesOrderTotalAmount(SalesOrderTotalAmount salesOrderTotalAmount) {
        this.salesOrderTotalAmount = salesOrderTotalAmount;
    }

    public void setSalesOrderDate(SalesOrderDate salesOrderDate) {
        this.salesOrderDate = salesOrderDate;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public SalesOrder(PlaceOrderCommand placeOrderCommand) {

        this.placingOrderID = placeOrderCommand.getPlacingOrderID();
        this.salesOrderDate = placeOrderCommand.getSalesOrderDate();
        this.customerId = placeOrderCommand.getCustomerId();
        this.productIds = placeOrderCommand.getProductIds();
        this.salesOrderTotalAmount = placeOrderCommand.getSalesOrderTotalAmount();


        addDomainEvent(new OrderPlacedEvent(new OrderPlacedEventData(placingOrderID.toString() ,  placeOrderCommand.getProductIds())));
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "orderId=" + orderId +
                ", placingOrderID=" + placingOrderID +
                ", salesOrderTotalAmount=" + salesOrderTotalAmount +
                ", salesOrderDate=" + salesOrderDate +
                ", productIds=" + productIds +
                ", customerId=" + customerId +
                '}';
    }

    /*
    public void placeOrder( PlaceOrderCommand placeOrderCommand) {

    }
   not needed now
 */



    public void addDomainEvent(Object event) {
        registerEvent(event) ;

    }



}
