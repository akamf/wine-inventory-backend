package akamf.wine_inventory.graphql.dto;

public record WineInputDto(
    String name,
    String type,
    String country,
    Integer year,
    Double price
) { }