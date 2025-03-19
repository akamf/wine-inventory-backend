package akamf.wine_inventory.service;

import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.repository.WineInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WineInventoryService {
    private final WineInventoryRepository wineInventoryRepository;

    public Mono<WineInventory> getInventoryByUserId(String userId) {
        return wineInventoryRepository.findByUserId(userId);
    }

    public Mono<WineInventory> createInventory(WineInventory inventory) {
        return wineInventoryRepository.save(inventory);
    }
}
