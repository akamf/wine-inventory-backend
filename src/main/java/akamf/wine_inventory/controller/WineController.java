package akamf.wine_inventory.controller;

import akamf.wine_inventory.model.Wine;
import akamf.wine_inventory.service.WineService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wines")
@RequiredArgsConstructor
public class WineController {
    private final WineService wineService;

    @GetMapping
    public Flux<Wine> getAllWines() { return wineService.getAllWines(); }

    @GetMapping("/{id}")
    public Mono<Wine> getWineById(@PathVariable String id) { return wineService.getWineById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Wine> createWine(@RequestBody Wine wine) { return wineService.createWine(wine); }

    @PutMapping("/{id}")
    public Mono<Wine> updateWine(@PathVariable String id, @RequestBody Wine wine) { return wineService.updateWine(id, wine); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteWine(@PathVariable String id) { return wineService.deleteWine(id); }

}
