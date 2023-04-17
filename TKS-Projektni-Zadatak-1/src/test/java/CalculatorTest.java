import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @BeforeEach
    public void setUpCalculator() {
        calculator.setCurrentValue(0.0);
    }

    @Test
    void testConstructor(){
        assertNotNull(calculator);
    }

    private static Stream<Arguments> calculateMethod() {
        return Stream.of(
                Arguments.of(0, 0, '+', 0),
                Arguments.of(0, -1, '+', -1),
                Arguments.of(0, 5, '*', 0),
                Arguments.of(10, 5, '*', 50),
                Arguments.of(10, 5, '/', 2.00),
                Arguments.of(10, 5, '/', 2.00),
                Arguments.of(0, 10, '-', -10));
    }

    @ParameterizedTest
    @MethodSource("calculateMethod")
    void testCalculate(double currentValue, double value, char operator, double result) throws DivisionByZeroException, NotSupportedOperationException {
        calculator.setCurrentValue(currentValue);
        calculator.calculate(value, operator);
        assertThat(result, is(calculator.getCurrentValue()));
    }

    private static Stream<Arguments> calculateExceptionMethod() {
        return Stream.of(
                Arguments.of(5, 0, '/', DivisionByZeroException.class),
                Arguments.of(1, 1, '#', NotSupportedOperationException.class));
    }

    @ParameterizedTest
    @MethodSource("calculateExceptionMethod")
    void testExceptionCalculate(double currentValue, double value, char operator, Class<? extends Exception> expectedException) throws DivisionByZeroException, NotSupportedOperationException {
        calculator.setCurrentValue(currentValue);
        assertThrows(expectedException, () -> calculator.calculate(value, operator));
    }
}