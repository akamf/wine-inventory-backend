package akamf.wine_inventory.graphql.mutation;

import akamf.wine_inventory.graphql.dto.UserInputDto;
import akamf.wine_inventory.model.User;
import akamf.wine_inventory.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class UserMutation {

    private final UserService userService;

    @DgsMutation
    public Mono<User> createUser(@InputArgument("userInput") UserInputDto userInput) {
        return userService.createUser(userInput);
    }
}
