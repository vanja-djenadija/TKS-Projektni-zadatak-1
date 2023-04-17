/**
 * Class providing basic arithmetic operations to work with calculator, such as
 * addition, subtraction, division or multiplication.
 *
 * @author Vanja Djenadija
 * @since 25.11.2022
 */
public class Calculator {
    private Double currentValue = 0.0;

    /**
     * Default constructor.
     */
    public Calculator() {

    }

    /**
     * Method for calculating basic operations. Left side operand is <b>currentValue</b>.
     *
     * @param value    the right side operand
     * @param operator basic operator for addition, subtraction, division or multiplication
     * @throws NotSupportedOperationException throws when not supported operator is provided as an argument
     * @throws DivisionByZeroException        throws when we divide by zero
     */
    public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException {
        switch (operator) {
            case '+':
                currentValue += value;
                break;
            case '-':
                currentValue -= value;
                break;
            case '/':
                if (value == 0.0)
                    throw new DivisionByZeroException();
                currentValue /= value;
                break;
            case '*':
                currentValue *= value;
                break;
            default:
                throw new NotSupportedOperationException();
        }
    }

    /**
     * Getter method.
     *
     * @return currentValue stored in Calculator
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Setter method.
     *
     * @param currentValue Value stored in calculator.
     */
    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }
}