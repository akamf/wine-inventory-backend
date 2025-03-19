package akamf.wine_inventory.service;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.model.WineEntry;
import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.repository.WineInventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

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

    public Mono<WineInventory> addWineToInventory(String userId, Wine wine) {
        return wineInventoryRepository.findByUserId(userId)
            .flatMap(inventory -> {
                String wineId = wine.id();
                WineEntry newEntry = new WineEntry(wineId, wine, LocalDateTime.now(), null);
                inventory.currentWines().put(wineId, newEntry);
                return wineInventoryRepository.save(inventory);
            });
    }

    public Mono<WineInventory> removeWineFromInventory(String userId, String wineId) {
        return wineInventoryRepository.findByUserId(userId)
            .flatMap(inventory -> {
                if (inventory.currentWines().containsKey(wineId)) {
                    WineEntry entry = inventory.currentWines().remove(wineId);
                    WineEntry historyEntry = new WineEntry(
                            entry.id(), entry.wine(), entry.dateAcquired(), LocalDateTime.now()
                    );
                    inventory.wineHistory().put(wineId, historyEntry);
                }
                return wineInventoryRepository.save(inventory);
            });
    }
}
