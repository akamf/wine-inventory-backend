package akamf.wine_inventory.repository;

import akamf.wine_inventory.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findUserByUsername(String username);
}
