package akamf.wine_inventory.service;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.repository.WineRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WineService {
    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public Flux<Wine> getAllWines() { return wineRepository.findAll(); }

    public Mono<Wine> getWineById(String id) { return wineRepository.findById(id); }

    public Mono<Wine> createWine(Wine wine) { return wineRepository.save(wine); }

    public Mono<Wine> updateWine(String id, Wine wine) {
        return wineRepository.findById(id)
                .flatMap(wineToUpdate -> {
                    wineToUpdate.setName(wine.getName());
                    wineToUpdate.setCountry(wine.getCountry());
                    wineToUpdate.setType(wine.getType());
                    wineToUpdate.setYear(wine.getYear());
                    wineToUpdate.setPrice(wine.getPrice());
                    return wineRepository.save(wineToUpdate);
                });
    }

    public Mono<Void> deleteWine(String id) { return wineRepository.deleteById(id); }
}
