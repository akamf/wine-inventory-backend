package akamf.wine_inventory.graphql.dto;

public record UserInputDto(
    String username,
    String password,
    String email
) { }
