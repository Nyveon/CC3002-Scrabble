package types;

/**
 * Scrabble variable which encapsulates a java double.
 * Interestingly called a float?
 */
public class ScrabbleFloat extends AbstractScrabbleNumber {
    private double value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleFloat Scrabble variable.
     * @param val A java double.
     */
    public ScrabbleFloat(double val) {
        this.value = val;
    }

    /**
     * Procures the value of the variable as a String.
     * Overrides Object toString.
     * @return Value as a java string.
     */
    @Override public String toString() {
        return Double.toString(value);
    }

    /**
     * Copies the object.
     * @return identical copy ScrabbleFloat.
     */
    public ScrabbleFloat copy() {
        return new ScrabbleFloat(value);
    }

    // ------<For testing>------
    /**
     * Compares a ScrabbleFloat with another object
     * @param obj Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object obj) {
        if (obj instanceof ScrabbleFloat) {
            var o = (ScrabbleFloat) obj;
            return o.value == this.value;
        }
        return false;
    }

    // ------<Conversions>------

    /**
     * Convert ScrabbleFloat to ScrabbleString.
     * @return ScrabbleString made with the string cast of the value
     */
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }

    /**
     * Convert ScrabbleFloat to ScrabbleFloat.
     * @return copy of the original ScrabbleFloat.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return copy();
    }
}
