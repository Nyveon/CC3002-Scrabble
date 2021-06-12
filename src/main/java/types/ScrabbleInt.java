package types;

import java.util.Objects;

/**
 * Scrabble variable which encapsulates a java integer.
 */
public class ScrabbleInt extends AbstractScrabbleVariable implements IScrabbleNumber {
    private final int value;

    // ------<Getters and setters>------

    /**
     * Getter for the main value of the scrabble variable.
     * @return value of the variable, as the corresponding java variable type.
     */
    int getValue() {
        return this.value;
    }

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
     * Compares a this object with another object
     * Generated directly by IntelliJ.
     * @param o Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabbleInt that = (ScrabbleInt) o;
        return value == that.value;
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

    // ------<Conversions>------

    /**
     * Convert ScrabbleInt to ScrabbleFloat.
     * @return ScrabbleFloat made with the double cast of the value.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat(value);
    }

    /**
     * Convert ScrabbleInt to ScrabbleInt.
     * @return copy of the original ScrabbleInt.
     */
    public ScrabbleInt toScrabbleInt() {
        return copy();
    }

    /**
     * Convert ScrabbleInt to ScrabbleBinary.
     * @return Binary string representation of the integer.
     */
    public ScrabbleBinary toScrabbleBinary() {
        int value_b = Math.abs(value);
        //  Two's complement
        if (value < 0) {
            value_b = ~value_b;
            value_b++;
        }
        // Is this legal?
        StringBuilder value_binary = new StringBuilder(Integer.toBinaryString(value_b));
        // Add leading 0s
        int n = value_binary.length();
        for (int i = n; i < 32; i++) {
            value_binary.insert(0, "0");
        }

        return new ScrabbleBinary(value_binary.toString());
    }

    // ------<Operations>------

    // -- With Int --

    /**
     * Method to add a ScrabbleInt with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt plus(ScrabbleInt other_value) {
        return new ScrabbleInt(this.value + other_value.getValue());
    }

    /**
     * Method to subtract a ScrabbleInt with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt minus(ScrabbleInt other_value) {
        return new ScrabbleInt(this.value - other_value.getValue());
    }

    /**
     * Method to multiply a ScrabbleInt with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt times(ScrabbleInt other_value) {
        return new ScrabbleInt(this.value * other_value.getValue());
    }

    /**
     * Method to divide a ScrabbleInt with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt div(ScrabbleInt other_value) {
        return new ScrabbleInt(this.value / other_value.getValue());
    }

    // -- With Binary --
    /**
     * Method to add a ScrabbleInt with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt plus(ScrabbleBinary other_value) {
        return new ScrabbleInt(this.value + other_value.toScrabbleInt().getValue());
    }

    /**
     * Method to subtract a ScrabbleInt with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt minus(ScrabbleBinary other_value) {
        return new ScrabbleInt(this.value - other_value.toScrabbleInt().getValue());
    }

    /**
     * Method to multiply a ScrabbleInt with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt times(ScrabbleBinary other_value) {
        return new ScrabbleInt(this.value * other_value.toScrabbleInt().getValue());
    }

    /**
     * Method to divide a ScrabbleInt with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleInt with resulting value.
     */
    @Override
    public ScrabbleInt div(ScrabbleBinary other_value) {
        return new ScrabbleInt(this.value / other_value.toScrabbleInt().getValue());
    }

    // -- With Float --
    // Not possible to return int, so returns float.
    /**
     * Method to add a ScrabbleInt with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat plus(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.toScrabbleFloat().getValue() + other_value.getValue());
    }

    /**
     * Method to subtract a ScrabbleInt with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat minus(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.toScrabbleFloat().getValue() - other_value.getValue());
    }

    /**
     * Method to multiply a ScrabbleInt with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat times(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.toScrabbleFloat().getValue() * other_value.getValue());
    }

    /**
     * Method to divide a ScrabbleInt with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat div(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.toScrabbleFloat().getValue() / other_value.getValue());
    }

}
