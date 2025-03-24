package akamf.wine_inventory.graphql.query;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.service.WineService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class WineQuery {

    private final WineService wineService;

    @DgsQuery
    public Flux<Wine> getAllWines() {
        return wineService.getAllWines();
    }

    @DgsQuery
    public Mono<Wine> getWineById(@InputArgument String id) {
        return wineService.getWineById(id);
    }
}
