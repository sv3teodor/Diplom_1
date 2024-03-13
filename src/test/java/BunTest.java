import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import util.BaseTest;

import java.util.Collections;

import static config.TestConfig.MAX_BUN_NAME;
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

    @Test
    public void testEmptyName() {
        bunName = "";
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testNullName() {
        bunName = null;
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testLongName() {
        bunName = "abcdefghijklmnopqrstuvwxyz";
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testSpecialCharactersName() {
        bunName = "!@#$%^&*()_+{}|:<>?[];',./`~";
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        bunPrice = -10f;
        bun = new Bun(bunName, bunPrice);
        /*
        Этот тест возвращает ошибку, т.к. следуя здравой логике цена не может быть отрицательная.
        И вероятно следует добавить в конструктор класса проверку, что переданы верные параметры.
        Если это не так, то можно бросить исключение "IllegalArgumentException"
         */
    }

    @Test
    public void testZeroPrice() {
        bunPrice = 0f;
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.001f);
    }

    @Test
    public void testMinimumPositivePrice() {
        bunPrice = Float.MIN_VALUE;
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.001f);
    }

    @Test
    public void testMaximumPositivePrice() {
        bunPrice = Float.MAX_VALUE;
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.001f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhitespaceName() {
        bunName = "    ";
        bun = new Bun(bunName, bunPrice);
         /*
         Разумно будет добавить проверку на пустое значение в классе и бросать исключение "IllegalArgumentException"
         */
    }

    @Test
    public void testMaxLengthName() {
        /*
        Проверяем с именем максимальной длинны.
        В задании нет информации о допустимой длине имени, по этому вынес ее в отдельную константу.
        Можно было бы проверять используя максимальную длину строки-
        bunName = String.join("", Collections.nCopies(Integer.MAX_VALUE-2, "a"));
        Но это требует увеличение кучи в JVM и на практике это бесполезный тест т.к. такого названия бургера не мажет быть.
         */

        bunName = String.join("", Collections.nCopies(MAX_BUN_NAME, "a"));
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }


}