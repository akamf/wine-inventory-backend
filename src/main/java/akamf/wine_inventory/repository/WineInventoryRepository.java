package akamf.wine_inventory.repository;

import akamf.wine_inventory.model.WineInventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface WineInventoryRepository extends ReactiveMongoRepository<WineInventory, String> {
    Mono<WineInventory> findByUserId(String id);
}
