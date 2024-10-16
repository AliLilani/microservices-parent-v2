package com.csci318_group13.Inventory_Service.interfaces;

import com.csci318_group13.Inventory_Service.application.commandservices.AddInventoryCommandService;
import com.csci318_group13.Inventory_Service.application.queryservices.InventoryQueryService;
import com.csci318_group13.Inventory_Service.domain.model.aggregate.InventoryItem;
import com.csci318_group13.Inventory_Service.interfaces.rest.dto.InventoryResource;
import com.csci318_group13.Inventory_Service.interfaces.transform.AddInventoryItemCommandDTOAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class InventoryController {

    AddInventoryCommandService addInventoryCommandService ;
    InventoryQueryService inventoryQueryService ;

    public InventoryController(AddInventoryCommandService addInventoryCommandService , InventoryQueryService inventoryQueryService) {
        this.addInventoryCommandService = addInventoryCommandService;
        this.inventoryQueryService = inventoryQueryService ;
    }

    @PostMapping("/api/inventory/addItem")
    public ResponseEntity<InventoryItem> addInventory(@RequestBody InventoryResource inventoryResource) {


       InventoryItem saved =  addInventoryCommandService.addInventoryItem(AddInventoryItemCommandDTOAssembler.toCommandFromDTO(inventoryResource));

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }


    @GetMapping("/api/inventory/findAllItems")
    public List<InventoryItem> findAllItems() {
       return  inventoryQueryService.findAllInventoryItems();
    }

    @GetMapping("/api/inventory/findItemsBelowStockLevel/{stockQuantity}")
    public List<InventoryItem> findItemsBelowStockLevel(@PathVariable Integer stockQuantity) {

     return  inventoryQueryService.findInventoryItemsBelowStockLevel(stockQuantity) ;
    }



}

