package model.types.numbers;

import model.types.AbstractScrabbleVariable;

import java.util.Objects;

/**
 * Scrabble variable which encapsulates a java double.
 * Interestingly called a float?
 */
public class ScrabbleFloat extends AbstractScrabbleVariable implements IScrabbleNumber {
    private final double value;

    /**
     * Getter for the main value of the scrabble variable.
     * @return value of the variable, as the corresponding java variable type.
     */
    public double getValue() {
        return this.value;
    }

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
     * Compares a this object with another object
     * Generated directly by IntelliJ.
     * @param o Any other object.
     * @return True if they are the same object, false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrabbleFloat that = (ScrabbleFloat) o;
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
     * Convert ScrabbleFloat to ScrabbleFloat.
     * @return copy of the original ScrabbleFloat.
     */
    public ScrabbleFloat toScrabbleFloat() {
        return copy();
    }

    // ------<Operations>------

    // -- With Int --

    /**
     * Method to add a ScrabbleFloat with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat plus(ScrabbleInt other_value) {
        return new ScrabbleFloat(this.value + other_value.getValue());
    }

    /**
     * Method to subtract a ScrabbleFloat with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat minus(ScrabbleInt other_value) {
        return new ScrabbleFloat(this.value - other_value.getValue());
    }

    /**
     * Method to multiply a ScrabbleFloat with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat times(ScrabbleInt other_value) {
        return new ScrabbleFloat(this.value * other_value.getValue());
    }

    /**
     * Method to divide a ScrabbleFloat with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat div(ScrabbleInt other_value) {
        return new ScrabbleFloat(this.value / other_value.getValue());
    }

    // -- With Binary --
    /**
     * Method to add a ScrabbleFloat with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat plus(ScrabbleBinary other_value) {
        return new ScrabbleFloat(this.value + other_value.toScrabbleFloat().getValue());
    }

    /**
     * Method to subtract a ScrabbleFloat with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat minus(ScrabbleBinary other_value) {
        return new ScrabbleFloat(this.value - other_value.toScrabbleFloat().getValue());
    }

    /**
     * Method to multiply a ScrabbleFloat with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat times(ScrabbleBinary other_value) {
        return new ScrabbleFloat(this.value * other_value.toScrabbleFloat().getValue());
    }

    /**
     * Method to divide a ScrabbleFloat with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    @Override
    public ScrabbleFloat div(ScrabbleBinary other_value) {
        return new ScrabbleFloat(this.value / other_value.toScrabbleFloat().getValue());
    }

    // -- With Float --
    // Not possible to return int, so returns float.
    /**
     * Method to add a ScrabbleFloat with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat plus(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.value + other_value.getValue());
    }

    /**
     * Method to subtract a ScrabbleFloat with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat minus(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.value - other_value.getValue());
    }

    /**
     * Method to multiply a ScrabbleFloat with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat times(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.value * other_value.getValue());
    }

    /**
     * Method to divide a ScrabbleFloat with a ScrabbleFloat
     * @param other_value ScrabbleFloat object to be operated with.
     * @return new ScrabbleFloat with resulting value.
     */
    public ScrabbleFloat div(ScrabbleFloat other_value) {
        return new ScrabbleFloat(this.value / other_value.getValue());
    }
}
