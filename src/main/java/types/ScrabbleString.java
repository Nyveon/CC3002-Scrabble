package types;


/**
 * Scrabble variable which encapsulates a java string.
 */
public class ScrabbleString extends AbstractScrabbleVariable {
    private String value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleString Scrabble variable.
     * @param val A java string.
     */
    public ScrabbleString(String val) {
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
     * @return identical copy ScrabbleString.
     */
    public ScrabbleString copy() {
        return new ScrabbleString(this.value);
    }


    // ------<For testing>------
    /**
     * Compares a ScrabbleString with another object
     * @param obj Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return o.value.equals(this.value);
        }
        return false;
    }


    // ------<Conversions>------

    /**
     * Convert ScrabbleString to ScrabbleString.
     * @return copy of the original ScrabbleString.
     */
    public ScrabbleString toScrabbleString() {
        return copy();
    }
}
