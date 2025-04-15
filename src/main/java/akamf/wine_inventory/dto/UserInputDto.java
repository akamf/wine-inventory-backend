package akamf.wine_inventory.dto;

public record UserInputDto(
    String username,
    String password,
    String email
) { }
