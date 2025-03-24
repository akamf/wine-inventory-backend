package akamf.wine_inventory.graphql.query;

import akamf.wine_inventory.model.User;
import akamf.wine_inventory.service.UserService;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class UserQuery {

    private final UserService userService;

    @DgsQuery
    public Mono<User> getUser(@InputArgument String username) {
        return userService.getUserByUsername(username);
    }

    @DgsQuery
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
