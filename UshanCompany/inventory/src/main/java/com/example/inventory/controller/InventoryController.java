package com.example.inventory.controller;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getinventory")
    public List<InventoryDTO> getInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/inventory/{inventoryId}")
    public InventoryDTO getInventoryById(@PathVariable Integer inventoryId) {
        return inventoryService.getInventoryById(inventoryId);
    }

    @PostMapping("/addinventory")
    public InventoryDTO savaInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PutMapping("/updateinventory")
    public InventoryDTO updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateInventory(inventoryDTO);
    }

    @DeleteMapping("/deleteinventory/{inventoryId}")
    public String deleteInventory(@PathVariable Integer inventoryId) {
        return inventoryService.deleteInventory(inventoryId);
    }
}
