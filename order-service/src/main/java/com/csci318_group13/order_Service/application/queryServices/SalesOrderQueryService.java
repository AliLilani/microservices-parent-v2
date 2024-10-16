package com.csci318_group13.order_Service.application.queryServices;

import com.csci318_group13.order_Service.domain.model.aggregates.SalesOrder;
import com.csci318_group13.order_Service.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderQueryService {

    private final SalesOrderRepository salesOrderRepository ;

    public SalesOrderQueryService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }



    public List<SalesOrder> findAllOrdersPlaced() {
        return salesOrderRepository.findAll();

    }

    public SalesOrder findSalesOrderByPlacingID(Long placingId) {
        return salesOrderRepository.findByPlacingOrderID(placingId);
    }

    public List<SalesOrder>  findAllOrdersByCustomer(Long customerId) {
        return  salesOrderRepository.findAllOrdersByCUstomerID(customerId) ;
    }

    public List<SalesOrder> findAllOrdersExceedingAount ( Double amount) {
        return  salesOrderRepository.findAllOrdersExceedingAmount(amount) ;
    }
}
