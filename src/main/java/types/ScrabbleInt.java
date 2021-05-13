package types;

/**
 * Scrabble variable which encapsulates a java integer.
 */
public class ScrabbleInt extends AbstractScrabbleNumber {
    private int value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleInt Scrabble variable.
     * @param val A java double.
     */
    public ScrabbleInt(int val) {
        this.value = val;
    }

    /**
     * Procures the value of the variable as a String.
     * Overrides Object toString.
     * @return Value as a java string.
     */
    @Override public String toString() {
        return Integer.toString(value);
    }

    /**
     * Copies the object.
     * @return identical copy ScrabbleInt.
     */
    public ScrabbleInt copy() {
        return new ScrabbleInt(value);
    }

    // ------<For testing>------
    /**
     * Compares a ScrabbleInt with another object
     * @param obj Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return o.value == this.value;
        }
        return false;
    }

    // ------<Conversions>------

    /**
     * Convert ScrabbleInt to ScrabbleString.
     * @return ScrabbleString made with the string cast of the value
     */
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }

    /**
     * Convert ScrabbleInt to ScrabbleFloat.
     * @return ScrabbleFloat made with the double cast of the value.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat((double) value);
    }

    /**
     * Convert ScrabbleInt to ScrabbleInt.
     * @return copy of the original ScrabbleInt.
     */
    public ScrabbleInt toScrabbleInt() {
        return copy();
    }

    //todo: int to binary
}
