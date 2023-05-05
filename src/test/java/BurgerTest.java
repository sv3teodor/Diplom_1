import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import util.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest extends BaseTest {

    private Bun mockBun;
    private Ingredient mockIngredientFirst;
    private Ingredient mockIngredientSecond;

    @Before
    public void setup() {
        mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn(faker.pokemon().name());
        when(mockBun.getPrice()).thenReturn((float) faker.random().nextDouble());

        mockIngredientFirst = mock(Ingredient.class);
        when(mockIngredientFirst.getName()).thenReturn(faker.food().ingredient());
        when(mockIngredientFirst.getPrice()).thenReturn((float) faker.random().nextDouble());
        when(mockIngredientFirst.getType()).thenReturn(IngredientType.values()[faker.random().nextInt(0, IngredientType.values().length - 1)]);

        mockIngredientSecond = mock(Ingredient.class);
        when(mockIngredientSecond.getName()).thenReturn(faker.food().ingredient());
        when(mockIngredientSecond.getPrice()).thenReturn((float) faker.random().nextDouble());
        when(mockIngredientSecond.getType()).thenReturn(IngredientType.values()[faker.random().nextInt(0, IngredientType.values().length - 1)]);

    }

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredientFirst);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredientFirst, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredientFirst);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);
        burger.moveIngredient(1, 0);
        assertEquals(mockIngredientSecond, burger.ingredients.get(0));
        assertEquals(mockIngredientFirst, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);
        Float totalPrice = (mockBun.getPrice() * 2) + mockIngredientFirst.getPrice() + mockIngredientSecond.getPrice();
        assertEquals(totalPrice, burger.getPrice(), 0.0001f);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);

        String expectedReceipt = String.format("(==== %s ====)%n", mockBun.getName()) +
                String.format("= %s %s =%n", mockIngredientFirst.getType().toString().toLowerCase(), mockIngredientFirst.getName()) +
                String.format("(==== %s ====)%n", mockBun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}

