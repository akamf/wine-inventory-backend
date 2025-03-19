package akamf.wine_inventory.controller;

import akamf.wine_inventory.model.User;
import akamf.wine_inventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{username}")
    public Mono<User> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
