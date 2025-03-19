package akamf.wine_inventory.service;

import akamf.wine_inventory.model.User;
import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.repository.UserRepository;

import akamf.wine_inventory.repository.WineInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WineInventoryRepository wineInventoryRepository;

    public Mono<User> createUser(User user) {
        String inventoryId = UUID.randomUUID().toString();
        WineInventory inventory = new WineInventory(
                inventoryId, user.id(), new HashMap<>(), new HashMap<>()
        );

        return wineInventoryRepository.save(inventory)
                .then(userRepository.save(new User(
                    user.id(),
                    user.username(),
                    user.password(),
                    user.email(),
                    LocalDateTime.now(),
                    null,
                    inventoryId
                )));
    }

    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
