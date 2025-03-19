package akamf.wine_inventory.controller;

import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.service.WineInventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
public class WineInventoryController {
    private final WineInventoryService wineInventoryService;

    @GetMapping("/{userId}")
    public Mono<WineInventory> getInventory(@PathVariable String userId) {
        return wineInventoryService.getInventoryByUserId(userId);
    }

    @PostMapping
    public Mono<WineInventory> createInventory(@RequestBody WineInventory inventory) {
        return wineInventoryService.createInventory(inventory);
    }
}
