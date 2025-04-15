package akamf.wine_inventory.service;

import akamf.wine_inventory.dto.WineInputDto;
import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.repository.WineRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WineService {
    private final WineRepository wineRepository;

    public Flux<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    public Mono<Wine> getWineById(String id) {
        return wineRepository.findById(id);
    }

    public Mono<Wine> createWine(WineInputDto wineInput) {
        Wine wine = new Wine(
                UUID.randomUUID().toString(),
                wineInput.name(),
                wineInput.country(),
                wineInput.type(),
                wineInput.year(),
                wineInput.price()
        );
        return wineRepository.save(wine);
    }

    public Mono<Wine> updateWine(String id, WineInputDto wineInput) {
        return wineRepository.findById(id)
                .map(existingWine -> new Wine(
                        existingWine.id(),  // keep same ID
                        wineInput.name(),
                        wineInput.country(),
                        wineInput.type(),
                        wineInput.year(),
                        wineInput.price()
                ))
                .flatMap(wineRepository::save);
    }

    public Mono<Void> deleteWine(String id) {
        return wineRepository.deleteById(id);
    }
}
