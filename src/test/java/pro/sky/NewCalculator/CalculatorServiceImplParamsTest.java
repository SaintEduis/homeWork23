package pro.sky.NewCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pro.sky.NewCalculator.Exceptions.DivideByZeroException;
import pro.sky.NewCalculator.Services.CalculatorService;
import pro.sky.NewCalculator.Services.CalculatorServiceImpl;

import java.util.stream.Stream;

public class CalculatorServiceImplParamsTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    public static Stream<Arguments> provideParamsForPlusTest() {
        return Stream.of(
                Arguments.of(2, 4, "2 + 4 = 6"),
                Arguments.of(-3, 0, "-3 + 0 = -3")
        );
    }

    public static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(
                Arguments.of(2, 4, "2 - 4 = -2"),
                Arguments.of(-3, 0, "-3 - 0 = -3")
        );
    }

    public static Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(
                Arguments.of(2, 4, "2 * 4 = 8"),
                Arguments.of(-3, 0, "-3 * 0 = 8")
        );
    }

    public static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(
                Arguments.of(2, 4, "4 / 2 = 2"),
                Arguments.of(-3, 0, "0 / 3 = 0")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    public void plus(int firstNumb, int secondNumb, String expectedResult) {
        String result = out.plus(firstNumb, secondNumb);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    public void minus(int firstNumb, int secondNumb, String expectedResult) {
        String result = out.plus(firstNumb, secondNumb);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    public void multiply(int firstNumb, int secondNumb, String expectedResult) {
        String result = out.plus(firstNumb, secondNumb);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    public void divide(int firstNumb, int secondNumb, String expectedResult) {
        String result = out.plus(firstNumb, secondNumb);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void invalidDivide() {
        Assertions.assertThrows(DivideByZeroException.class, () -> out.divide(3, 0));
    }
}
