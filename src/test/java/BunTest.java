import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import util.BaseTest;

import static org.junit.Assert.assertEquals;


public class BunTest extends BaseTest {
    private String bunName;
    private Float bunPrice;
    private Bun bun;

    @Before
    public void setup() {
        bunName = faker.pokemon().name();
        bunPrice = (float) faker.random().nextDouble();
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void testGetName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0.001f);
    }


}