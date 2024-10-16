package com.csci318_group13.Inventory_Service.interfaces.transform;

import com.csci318_group13.Inventory_Service.domain.model.commands.AddInventoryItemCommand;
import com.csci318_group13.Inventory_Service.interfaces.rest.dto.InventoryResource;

public class AddInventoryItemCommandDTOAssembler {

    public static AddInventoryItemCommand toCommandFromDTO(InventoryResource  inventoryResource) {
        return new AddInventoryItemCommand(
                inventoryResource.getProductId() ,inventoryResource.getLocation(),inventoryResource.getStock() , inventoryResource.getExpiryDate()
        );
    }
}
