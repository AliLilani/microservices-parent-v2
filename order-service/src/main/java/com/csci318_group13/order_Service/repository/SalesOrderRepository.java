package com.csci318_group13.order_Service.repository;

import com.csci318_group13.order_Service.domain.model.aggregates.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import com.csci318_group13.order_Service.domain.model.aggregates.MyOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
   // public List<SalesOrder> findAllSalesOrder();
  // public SalesOrder  findBySalesOrderID(Long orderId);
   // public SalesOrder  findAllSalesOrderIds();
   public SalesOrder  findByPlacingOrderID(Long id) ;
   public List<SalesOrder> findAllOrdersByCUstomerID(Long customerID);
   public List<SalesOrder> findAllOrdersExceedingAmount(Double amount) ;

}

