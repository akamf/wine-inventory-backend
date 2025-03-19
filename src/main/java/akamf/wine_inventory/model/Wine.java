package akamf.wine_inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wines")
public record Wine(
        @Id String id,
        String name,
        String country,
        String type,
        int year,
        double price
) { }