package akamf.wine_inventory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="wines")
public class Wine {

    @Id
    private String id;
    private String name;
    private String country;
    private String type;
    private int year;
    private double price;

}
