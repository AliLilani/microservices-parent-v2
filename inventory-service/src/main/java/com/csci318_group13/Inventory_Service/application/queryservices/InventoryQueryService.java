package com.csci318_group13.Inventory_Service.application.queryservices;

import com.csci318_group13.Inventory_Service.domain.model.aggregate.InventoryItem;
import com.csci318_group13.Inventory_Service.domain.model.valueobjects.Stock;
import com.csci318_group13.Inventory_Service.infrastructure.InventoryRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryQueryService {
    private final InventoryRepository inventoryRepository;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(InventoryQueryService.class);


    public InventoryQueryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryItem> findAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public List<InventoryItem> findInventoryItemByProductId(Long id) {
        return inventoryRepository.findByProductId(id);
    }

    public Boolean isExpired(List<Long> ids) {
        for (Long id : ids) {
            for (InventoryItem inventoryItem : findInventoryItemByProductId(id)) {
                if (!inventoryItem.getExpiry().getExpiryDate().isAfter(LocalDate.now())) {
                    return true;
                }
            }


        }
        return false;

    }

    public void updateInventoryItemsStock(List<Long> productIds) {

        for (Long productId : productIds) {
            List<InventoryItem> inventoryItems = inventoryRepository.findByProductId(productId);

             if (inventoryItems.size() >= 1){

                Integer stockqQantity = inventoryItems.get(0).getStock().getStockQuantity() - 1;
                inventoryItems.get(0).setStock(new Stock(stockqQantity));
                inventoryRepository.save(inventoryItems.get(0));
            }

        }
    }

    public List<InventoryItem> findInventoryItemsBelowStockLevel(Integer stockQuantity) {
        return inventoryRepository.findItemsBelowStockLevel(stockQuantity) ;
    }

    public boolean isAvailable(List<Long> productIds) {

        for (Long id : productIds) {
            for (InventoryItem inventoryItem : findInventoryItemByProductId(id)) {
                //  InventoryItem inventoryItem =   inventoryRepository.findByProductId(id) ;

                if (inventoryItem.getStock().getStockQuantity() < 1) {
                    log.info("at least on item in order is not available in inventory");
                    return false;
                }
            }

        }
        return true;
    }
}
