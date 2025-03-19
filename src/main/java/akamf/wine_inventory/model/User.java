package akamf.wine_inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
public record User(
        @Id String id,
        String username,
        String password,
        String email,
        LocalDateTime createdAt,
        LocalDateTime lastLogin,
        String wineInventoryId
) { }
