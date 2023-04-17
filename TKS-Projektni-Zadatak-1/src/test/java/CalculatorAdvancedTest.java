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

class CalculatorAdvancedTest {

    private final CalculatorAdvanced calculator = new CalculatorAdvanced();

    @BeforeEach
    public void setUpCalculator() {
        calculator.setCurrentValue(0.0);
    }

    @Test
    void testConstructor(){
        assertNotNull(calculator);
    }

    private static Stream<Arguments> calculateAdvancedMethod() {
        return Stream.of(
                Arguments.of(0, '!', 1),
                Arguments.of(10, '!', 3628800),
                Arguments.of(0, '0', 1),
                Arguments.of(0, '1', 0),
                Arguments.of(2, '3', 8),
                Arguments.of(3, '!', 6));
    }

    @ParameterizedTest
    @MethodSource("calculateAdvancedMethod")
    void testCalculateAdvanced(double currentValue, char action, double result) throws NotSupportedOperationException, NumberNotInAreaException {
        calculator.setCurrentValue(currentValue);
        calculator.calculateAdvanced(action);
        assertThat(result, is(calculator.getCurrentValue()));
    }

    private static Stream<Arguments> calculateAdvancedExceptionMethod() {
        return Stream.of(
                Arguments.of(11, '!', NumberNotInAreaException.class),
                Arguments.of(10.002, '!', NumberNotInAreaException.class),
                Arguments.of(-0.01, '!', NumberNotInAreaException.class),
                Arguments.of(-1, '!', NumberNotInAreaException.class),
                Arguments.of(15, 'K', NotSupportedOperationException.class),
                Arguments.of(5, '#', NotSupportedOperationException.class));
    }

    @ParameterizedTest
    @MethodSource("calculateAdvancedExceptionMethod")
    void testExceptionCalculate(double currentValue, char action, Class<? extends Exception> expectedException) {
        calculator.setCurrentValue(currentValue);
        assertThrows(expectedException, () -> calculator.calculateAdvanced(action));
    }

    private static Stream<Arguments> hasCharacteristicMethod() {
        return Stream.of(
                Arguments.of(153.89, 'A', true),
                Arguments.of(1634.66, 'A', true),
                Arguments.of(16.66, 'A', false),
                Arguments.of(20, 'A', false),
                Arguments.of(1.00, 'A', true),
                Arguments.of(6, 'P', true),
                Arguments.of(1.00, 'P', false),
                Arguments.of(7, 'P', false));
    }

    @ParameterizedTest
    @MethodSource("hasCharacteristicMethod")
    void testHasCharacteristic(double currentValue, char action, boolean expectedResult) throws NotSupportedOperationException, NumberNotInAreaException {
        calculator.setCurrentValue(currentValue);
        boolean result = calculator.hasCharacteristic(action);
        assertThat(expectedResult, is(result));
    }

    private static Stream<Arguments> hasCharacteristicExceptionMethod() {
        return Stream.of(
                Arguments.of(0.5, 'A', NumberNotInAreaException.class),
                Arguments.of(0.99, 'A', NumberNotInAreaException.class),
                Arguments.of(0.99, 'P', NumberNotInAreaException.class),
                Arguments.of(5, 'S', NotSupportedOperationException.class));
    }

    @ParameterizedTest
    @MethodSource("hasCharacteristicExceptionMethod")
    void testHasCharacteristicExceptionCalculate(double currentValue, char action, Class<? extends Exception> expectedException) {
        calculator.setCurrentValue(currentValue);
        assertThrows(expectedException, () -> calculator.hasCharacteristic(action));
    }
}