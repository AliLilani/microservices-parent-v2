package com.csci318_group13.order_Service.interfaces;

import com.csci318_group13.order_Service.DTO.MySalesOrderResource;
import com.csci318_group13.order_Service.application.commandservices.MyOrderPlacingCommandService;
//import com.csci318_group13.order_Service.domain.model.aggregates.MyOrder;
import com.csci318_group13.order_Service.application.queryServices.SalesOrderQueryService;
import com.csci318_group13.order_Service.domain.model.aggregates.SalesOrder;
import com.csci318_group13.order_Service.service.OrderService;
import com.csci318_group13.order_Service.transform.PlaceOrderCommandDTOAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesOrderController {
    private final OrderService orderService;
    private final MyOrderPlacingCommandService myOrderPlacingCommandService;
    private final SalesOrderQueryService salesOrderQueryService;

    public SalesOrderController(OrderService orderService, MyOrderPlacingCommandService myOrderPlacingCommandService, SalesOrderQueryService salesOrderQueryService) {
        this.orderService = orderService;
        this.myOrderPlacingCommandService = myOrderPlacingCommandService;
        this.salesOrderQueryService = salesOrderQueryService;
    }

    @GetMapping("/api/orders/findAllOrders")
    public List<SalesOrder> findAllOrders() {

        return salesOrderQueryService.findAllOrdersPlaced();


    }

    @GetMapping("/api/orders/findAllOrdersByCustomer/{id}")
    public List<SalesOrder> findAllOrdersByCustomerid(@PathVariable Long id) {

        return salesOrderQueryService.findAllOrdersByCustomer(id) ;


    }

    @GetMapping("/api/orders/findAllOrdersExceedingAmount/{amount}")
    public List<SalesOrder> findAllOrdersExceedingAmount(@PathVariable Double amount) {

        return salesOrderQueryService.findAllOrdersExceedingAount(amount) ;


    }


   // this will be used by Notification service resttemplate to find order detail by
    //placingOrderID
    // note placingorderID differ from orderId
    @GetMapping("/api/orders/placingID/{placingId}")
    MySalesOrderResource findSalesOrderByPlacingID(@PathVariable String placingId){

        SalesOrder salesOrder  =  salesOrderQueryService.findSalesOrderByPlacingID(Long.parseLong(placingId));
        MySalesOrderResource mySalesOrderResource = new MySalesOrderResource();
        mySalesOrderResource.setCustomerId(salesOrder.getCustomerId());
        mySalesOrderResource.setSalesOrderDate(salesOrder.getSalesOrderDate());
        mySalesOrderResource.setSalesOrderTotalAmount(salesOrder.getSalesOrderTotalAmount());
        mySalesOrderResource.setProductIds(salesOrder.getProductIds());
        return mySalesOrderResource;

    }



    @PostMapping("/api/orders/placeOrder")
    public Long placeOrder(@RequestBody MySalesOrderResource mySalesOrderResource) {
        return myOrderPlacingCommandService.PlaceOrder(PlaceOrderCommandDTOAssembler.toCommandFromOrderREsource(mySalesOrderResource));
    }


}






