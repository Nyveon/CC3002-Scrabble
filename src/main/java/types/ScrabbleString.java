package types;


import java.util.Objects;

/**
 * Scrabble variable which encapsulates a java string.
 */
public class ScrabbleString extends AbstractScrabbleVariable {
    private final String value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleString Scrabble variable.
     * @param val A java string.
     */
    public ScrabbleString(String val) {
        this.value = val;
    }

    // ------<Getters and setters>------

    /**
     * Getter for the main value of the scrabble variable.
     * @return value of the variable, as the corresponding java variable type.
     */
    public String getValue() {
        return this.value;
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
     * Compares a this object with another object
     * Generated directly by IntelliJ.
     * @param o Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabbleString that = (ScrabbleString) o;
        return value.equals(that.value);
    }

    /**
     * Overrides Object hashCode.
     * Generated directly by IntelliJ.
     * @return hash of the class and value as an integer.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }


    // ------<Operations>------

    /**
     * Concatenate other scrabble variable's value, to this scrabble string's variable
     * @param other_value OTher wscrabble variable of any type
     * @return Scrabble String with the new value.
     */
    public ScrabbleString plus(IScrabbleVariable other_value) {
        return new ScrabbleString(this.value + other_value.toString());
    }

}
