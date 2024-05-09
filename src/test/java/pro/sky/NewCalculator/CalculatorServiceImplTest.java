package pro.sky.NewCalculator;

import org.junit.jupiter.api.Test;
import pro.sky.NewCalculator.Exceptions.DivideByZeroException;
import pro.sky.NewCalculator.Services.CalculatorService;
import pro.sky.NewCalculator.Services.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @Test
    public void plus() {
        String actual1 = "2 + 4 = 6";
        String actual2 = "-2 + 3 = 1";

        String expected1 = out.plus(2, 4);
        String expected2 = out.plus(-2, 3);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void minus() {
        String actual1 = "-2 - 4 = -6";
        String actual2 = "13 - 3 = 10";

        String expected1 = out.minus(-2, 4);
        String expected2 = out.minus(13, 3);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void multiply() {
        String actual1 = "2 * 3 = 6";
        String actual2 = "-2 * 2 = -4";

        String expected1 = out.multiply(2, 3);
        String expected2 = out.multiply(-2, 2);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void divide() {
        String actual1 = "4 / 2 = 2";
        String actual2 = "6 / -3 = -2";

        String expected1 = out.divide(4, 2);
        String expected2 = out.divide(6, -3);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public  void divideException() {
        assertThrows(DivideByZeroException.class, () -> out.divide(1, 0));
    }
}
