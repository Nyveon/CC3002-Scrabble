package types;

/**
 * Scrabble variable which encapsulates a java boolean.
 */

public class ScrabbleBool extends AbstractScrabbleVariable {
    private boolean value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleBool Scrabble variable.
     * @param val A java boolean.
     */
    public ScrabbleBool(boolean val) {
        this.value = val;
    }


    /**
     * Procures the value of the variable.
     * Overrides Object toString.
     * @return Value as a java string.
     */
    @Override public String toString() {
        return Boolean.toString(this.value);
    }


    /**
     * Copies the object.
     * @return identical copy ScrabbleBool.
     */
    public ScrabbleBool copy() {
        return new ScrabbleBool(this.value);
    }

    // ------<For testing>------
    /**
     * Compares a ScrabbleBool with another object
     * @param other Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object other) {
        if (other instanceof ScrabbleBool) {
            var o = (ScrabbleBool) other;
            return o.value == this.value;
        }
        return false;
    }


    // ------<Conversions>------

    /**
     * Convert ScrabbleBool to ScrabbleBool.
     * @return copy of the original ScrabbleBool.
     */
    public ScrabbleBool toScrabbleBool() {
        return copy();
    }


    /**
     * Convert ScrabbleBool to ScrabbleString.
     * @return ScrableString made with the string cast of the value
     */
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(Boolean.toString(value));
    }
}
