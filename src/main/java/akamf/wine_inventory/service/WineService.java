package akamf.wine_inventory.service;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.repository.WineRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    public Flux<Wine> getAllWines() { return wineRepository.findAll(); }

    public Mono<Wine> getWineById(String id) { return wineRepository.findById(id); }

    public Mono<Wine> createWine(Wine wine) { return wineRepository.save(wine); }

    public Mono<Wine> updateWine(String id, Wine wine) {
        return wineRepository.findById(id)
            .map(existingWine -> new Wine(
                    existingWine.id(),
                    wine.name(),
                    wine.country(),
                    wine.type(),
                    wine.year(),
                    wine.price()
            ))
            .flatMap(wineRepository::save);
    }

    public Mono<Void> deleteWine(String id) { return wineRepository.deleteById(id); }
}
