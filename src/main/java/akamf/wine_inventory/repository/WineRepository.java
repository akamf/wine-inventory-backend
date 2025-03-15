package akamf.wine_inventory.repository;

import akamf.wine_inventory.model.Wine;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends ReactiveMongoRepository<Wine, String> {
}
