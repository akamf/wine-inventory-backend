package akamf.wine_inventory.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public record WineEntry(
        @Id String id,
        Wine wine,
        LocalDateTime dateAcquired,
        LocalDateTime dateRemoved,
        int amount
) { }
