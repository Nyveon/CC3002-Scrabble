package types;

/**
 * Scrabble variable which encapsulates a java string, representing a number in binary.
 */
public class ScrabbleBinary extends AbstractScrabbleNumber {
    private String value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleBinary Scrabble variable.
     * @param val A java string.
     */
    public ScrabbleBinary(String val) {
        this.value = val;
    }

    /**
     * Procures the value of the variable.
     * Overrides Object toString.
     * @return Value as a java string.
     */
    @Override public String toString() {
        return this.value;
    }

    /**
     * Copies the object.
     * @return identical copy ScrabbleBinary.
     */
    public ScrabbleBinary copy() {
        return new ScrabbleBinary(value);
    }

    // ------<For testing>------
    /**
     * Compares a ScrabbleBinary with another object
     * @param obj Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return o.value == this.value;
        }
        return false;
    }

    // ------<Conversions>------

    /**
     * Convert ScrabbleBinary to ScrabbleString.
     * @return ScrabbleString made with the string cast of the value
     */
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }

    /**
     * Convert ScrabbleBinary to ScrabbleBinary.
     * @return copy of the original ScrabbleInt.
     */
    public ScrabbleBinary toScrabbleBinary() {
        return copy();
    }

    //todo: binary to int
    //todo: binary to float

    /**
     * Convert ScrabbleBinary to ScrabbleFloat.
     * @return float interpretation of the binary number.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return null; //todo: finish this
    }

    /**
     * Convert ScrabbleBinary to ScrabbleInt.
     * @return integer interpretation of the binary number.
     */
    public ScrabbleInt toScrabbleInt() {
        return null; //todo: finish this
    }
}
