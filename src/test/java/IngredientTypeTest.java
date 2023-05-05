import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String expectedToStringResult;

    public IngredientTypeTest(IngredientType ingredientType, String expectedToStringResult) {
        this.ingredientType = ingredientType;
        this.expectedToStringResult = expectedToStringResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        });
    }

    @Test
    public void testToString() {
        assertEquals(expectedToStringResult, ingredientType.toString());
    }
}
