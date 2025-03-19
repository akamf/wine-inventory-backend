package akamf.wine_inventory.service;

import akamf.wine_inventory.model.User;
import akamf.wine_inventory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> createUser(User user) { return userRepository.save(user); }

    public Mono<User> getUserByUsername(String username) { return userRepository.findByUsername(username); }
}
