package com.csci318_group13.Inventory_Service.infrastructure;

import com.csci318_group13.Inventory_Service.domain.model.aggregate.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  InventoryRepository extends JpaRepository<InventoryItem, Long> {
    public List<InventoryItem> findByProductId(Long id);
    public List<InventoryItem>  findItemsBelowStockLevel (Integer stockQuantity) ;


}
