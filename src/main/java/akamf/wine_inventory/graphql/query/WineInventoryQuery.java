package akamf.wine_inventory.graphql.query;

import akamf.wine_inventory.model.WineInventory;
import akamf.wine_inventory.service.WineInventoryService;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class WineInventoryQuery {

    private final WineInventoryService wineInventoryService;

    @DgsQuery
    public Mono<WineInventory> getInventoryByUserId(@InputArgument String userId) {
        return wineInventoryService.getInventoryByUserId(userId);
    }
}
