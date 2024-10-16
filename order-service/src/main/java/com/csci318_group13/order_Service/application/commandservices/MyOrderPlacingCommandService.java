package com.csci318_group13.order_Service.application.commandservices;

//import com.csci318_group13.order_Service.domain.model.aggregates.MyOrder;
import com.csci318_group13.order_Service.domain.model.aggregates.PlacingOrderID;
import com.csci318_group13.order_Service.domain.model.aggregates.SalesOrder;
import com.csci318_group13.order_Service.domain.model.commands.PlaceOrderCommand;
import com.csci318_group13.order_Service.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MyOrderPlacingCommandService {

    private final SalesOrderRepository salesOrderRepository;

    public MyOrderPlacingCommandService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public Long PlaceOrder (PlaceOrderCommand placeOrderCommand) {
        Long random = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE ;// convert UUID to LONG
        placeOrderCommand.setPlacingOrderID(new PlacingOrderID((random)));
        SalesOrder salesOrder = new SalesOrder(placeOrderCommand);

        salesOrderRepository.save(salesOrder) ;
        return random;

    }
}
