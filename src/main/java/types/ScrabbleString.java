package types;
import java.util.Objects;


/**
 * Scrabble variable which encapsulates a java string.
 */
public class ScrabbleString implements IScrabbleVariable {
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
        return value;
    }


    /**
     * Copies the object.
     * @return identical copy ScrabbleString.
     */
    public ScrabbleString copy() {
        return new ScrabbleString(value);
    }


    // ------<For testing>------

    /**
     * Overrides Object hashCode.
     * @return hash of the class as an integer.
     */
    @Override public int hashCode() {
        return Objects.hash(ScrabbleString.class);
    }


    /**
     * Compares a ScrabbleString with another object
     * @param other Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override public boolean equals(Object other) {
        if (other instanceof ScrabbleString) {
            var o = (ScrabbleString) other;
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
