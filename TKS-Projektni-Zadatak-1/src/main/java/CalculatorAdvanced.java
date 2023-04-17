/**
 * Class providing advanced arithmetic operations such as factorial and exponentiation.
 *
 * @author Vanja Djenadija
 * @since 25.11.2022
 */
public class CalculatorAdvanced extends Calculator {

    /**
     * Default constructor.
     */
    public CalculatorAdvanced() {

    }

    /**
     * Method taking the factorial or the power of <b>currentValue</b>.
     *
     * @param action operator for factorial and exponentiation
     * @throws NotSupportedOperationException throws if action provided is not number in range [0,9] or not !
     * @throws NumberNotInAreaException       throws if currentValue is outside given range [0,10]
     */
    public void calculateAdvanced(char action) throws NotSupportedOperationException, NumberNotInAreaException {
        if (!Character.isDigit(action) && action != '!')
            throw new NotSupportedOperationException();

        switch (action) {
            case '!':
                if (getCurrentValue() < 0 || getCurrentValue() > 10) {
                    throw new NumberNotInAreaException();
                }
                setCurrentValue((double) Util.factorial(getCurrentValue().intValue()));
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                setCurrentValue((double) Util.power(getCurrentValue().intValue(), Character.getNumericValue(action)));
                break;
        }
    }

    /**
     * Method for checking if a number has a given characteristic, being perfect or Armstrong.
     *
     * @param value character A for Armstrong number, character P for perfect number
     * @return true if <b>currentValue</B> has given characteristic (number is perfect or Armstrong), otherwise false
     * @throws NotSupportedOperationException throws if value is not P or A
     * @throws NumberNotInAreaException       throws if <b>currentValue</b> is less than 1
     */
    public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
        if (value != 'A' && value != 'P')
            throw new NotSupportedOperationException();

        if (getCurrentValue() < 1)
            throw new NumberNotInAreaException();

        if (value == 'A')
            return Util.isArmstrong(getCurrentValue().intValue());
        else
            return Util.isPerfect(getCurrentValue().intValue());
    }
}