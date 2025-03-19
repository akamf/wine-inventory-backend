package akamf.wine_inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "wine_inventories")
public record WineInventory(
        @Id String id,
        String userId,
        Map<String, WineEntry> currentWines,
        Map<String, WineEntry> wineHistory
) { }
