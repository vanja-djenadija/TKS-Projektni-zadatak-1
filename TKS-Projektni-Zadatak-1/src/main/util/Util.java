/**
 * Utility class for Calculator.
 *
 * @author Vanja Djenadija
 * @since 25.11.2022
 */
public final class Util {

    private Util() {

    }

    /**
     * Method for taking the factorial of a number.
     *
     * @param value number for which the factorial operation is being performed
     * @return the result of computing the factorial
     */
    public static int factorial(int value) {
        int factorial = 1;
        for (int i = value; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Method for computing the power of a number.
     *
     * @param value number for which the power operation is being performed
     * @param pow   power
     * @return the result of computing the power
     */
    public static int power(int value, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= value;
        }
        return result;
    }

    /**
     * Method for computing if a number is Armstrong or not.
     *
     * @param value number we are checking to see if it is Armstrong
     * @return true if a number is Armstrong, otherwise false
     */
    public static Boolean isArmstrong(int value) {
        int numberOfDigits = String.valueOf(value).length();
        int sumOfNPow = 0;
        int valueTemp = value;

        while (valueTemp != 0) {
            int currentDigit = valueTemp % 10;
            sumOfNPow += Math.pow(currentDigit, numberOfDigits);
            valueTemp /= 10;
        }

        return value == sumOfNPow;
    }

    /**
     * Method for computing if a number is perfect or not.
     *
     * @param value number we are checking to see if it is perfect
     * @return true if a number is perfect, otherwise false
     */
    public static Boolean isPerfect(int value) {
        int i = 1, sumOdDivisors = 0;
        while (i <= value / 2) {
            if (value % i == 0) {
                sumOdDivisors = sumOdDivisors + i;
            }
            i++;
        }
        return value == sumOdDivisors;
    }
}