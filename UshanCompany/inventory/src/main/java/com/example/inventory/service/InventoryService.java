package com.example.inventory.service;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.Inventory;
import com.example.inventory.repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<InventoryDTO>>(){}.getType());
    }

    public InventoryDTO saveInventory(InventoryDTO inventoryDTO){
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public InventoryDTO updateInventory(InventoryDTO inventoryDTO){
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }

    public String deleteInventory(Integer inventoryId) {
        inventoryRepo.deleteById(inventoryId);
        return "Inventory Deleted Successfully";
    }

    public InventoryDTO getInventoryById(Integer inventoryId) {
        Inventory inventory = inventoryRepo.getInventoriesBy(inventoryId);
        return modelMapper.map(inventory, InventoryDTO.class);
    }
}


