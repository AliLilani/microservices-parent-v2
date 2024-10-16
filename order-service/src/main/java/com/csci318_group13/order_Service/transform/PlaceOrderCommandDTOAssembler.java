package com.csci318_group13.order_Service.transform;

import com.csci318_group13.order_Service.DTO.MySalesOrderResource;
import com.csci318_group13.order_Service.domain.model.commands.PlaceOrderCommand;

public class PlaceOrderCommandDTOAssembler {

    public static PlaceOrderCommand toCommandFromOrderREsource( MySalesOrderResource mySalesOrderResource){
        return  new PlaceOrderCommand(
                mySalesOrderResource.getCustomerId(),mySalesOrderResource.getProductIds(),
                mySalesOrderResource.getSalesOrderDate(),mySalesOrderResource.getSalesOrderTotalAmount()
        );
    }


}
