package akamf.wine_inventory.dto;

public record WineInputDto(
    String name,
    String type,
    String country,
    Integer year,
    Double price
) { }