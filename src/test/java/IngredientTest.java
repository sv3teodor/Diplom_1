import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import util.BaseTest;

import static org.junit.Assert.assertEquals;

public class IngredientTest extends BaseTest {
    float ingredientPrice;
    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String ingredientName;

    @Before
    public void setup() {
        ingredientType = IngredientType.values()[faker.random().nextInt(0, IngredientType.values().length - 1)];
        ingredientName = faker.ancient().god();
        ingredientPrice = (float) faker.random().nextDouble();
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void testGetPrice() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetName() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(ingredientType, ingredient.getType());
    }
}