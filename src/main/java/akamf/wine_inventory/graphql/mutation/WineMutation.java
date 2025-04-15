package akamf.wine_inventory.graphql.mutation;

import akamf.wine_inventory.dto.WineInputDto;
import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.service.WineService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@DgsComponent
@RequiredArgsConstructor
public class WineMutation {

    private final WineService wineService;

    @DgsMutation
    public Mono<Wine> createWine(@InputArgument("wine") WineInputDto wineInput) {
        return wineService.createWine(wineInput);
    }

    @DgsMutation
    public Mono<Wine> updateWine(@InputArgument("id") String id, @InputArgument("wine") WineInputDto wineInput) {
        return wineService.updateWine(id, wineInput);
    }

    @DgsMutation
    public Mono<Void> deleteWine(@InputArgument String id) {
        return wineService.deleteWine(id);
    }
}
