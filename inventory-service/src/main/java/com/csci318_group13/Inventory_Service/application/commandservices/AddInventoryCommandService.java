package com.csci318_group13.Inventory_Service.application.commandservices;

import com.csci318_group13.Inventory_Service.domain.model.aggregate.InventoryItem;
import com.csci318_group13.Inventory_Service.domain.model.commands.AddInventoryItemCommand;
import com.csci318_group13.Inventory_Service.infrastructure.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class AddInventoryCommandService {
    private final InventoryRepository inventoryRepository ;

    public AddInventoryCommandService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryItem addInventoryItem(AddInventoryItemCommand addInventoryItemCommand) {
        InventoryItem inventoryItem = new InventoryItem(addInventoryItemCommand);

       InventoryItem saved =   inventoryRepository.save(inventoryItem);
       return saved ;
    }
}
