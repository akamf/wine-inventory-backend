package akamf.wine_inventory;

import akamf.wine_inventory.repository.WineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpringContextTest {

    @Autowired
    private WineRepository wineRepository;

    @Test
    void contextLoads() {
        assertNotNull(wineRepository);
    }
}
