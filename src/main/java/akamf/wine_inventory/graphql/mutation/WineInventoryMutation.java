package akamf.wine_inventory.graphql.mutation;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.service.WineInventoryService;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class WineInventoryMutation {

    private final WineInventoryService wineInventoryService;

    @DgsMutation
    public Mono<WineInventory> addWineToInventory(@InputArgument String userId, @InputArgument String wineId) {
        return wineInventoryService.addWineToInventory(userId, wineId);
    }

    @DgsMutation
    public Mono<WineInventory> removeWineFromInventory(@InputArgument String userId, @InputArgument String wineId) {
        return wineInventoryService.removeWineFromInventory(userId, wineId);
    }
}
