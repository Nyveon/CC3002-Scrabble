package types;

import java.util.Objects;

/**
 * Scrabble variable which encapsulates a java boolean.
 */

public class ScrabbleBool extends AbstractScrabbleVariable implements IScrabbleBinaries {
    private final boolean value;

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

    // ------<Getters and setters>------

    /**
     * Getter for the main value of the scrabble variable.
     * @return value of the variable, as the corresponding java variable type.
     */
    boolean getValue() {
        return this.value;
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
        ScrabbleBool that = (ScrabbleBool) o;
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
     * Convert ScrabbleBool to ScrabbleBool.
     * @return copy of the original ScrabbleBool.
     */
    public ScrabbleBool toScrabbleBool() {
        return copy();
    }

    // ------<Logical operations>------

    /**
     * Creates a new scrabble bool with the opposite of the value.
     * @return ScrabbleBool with new value.
     */
    public ScrabbleBool not() {
        return new ScrabbleBool(!this.value);
    }

    // With ScrabbleBool

    /**
     * Logical conjunction between two ScrabbleBools.
     * @param other_value  other ScrabbleBool object.
     * @return new ScrabbleBool with the resulting value.
     */
    public ScrabbleBool and(ScrabbleBool other_value) {
        return new ScrabbleBool(this.value && other_value.getValue());
    }

    /**
     * Logical disjunction between two ScrabbleBools.
     * @param other_value  other ScrabbleBool object.
     * @return new ScrabbleBool with the resulting value.
     */
    public ScrabbleBool or(ScrabbleBool other_value) {
        return new ScrabbleBool(this.value || other_value.getValue());
    }

    // With ScrabbleBinary

    /**
     * Auxiliary function that converts the boolean value of this ScrabbleBool
     * into a 32 character long binary representation of itself.
     * @return String (32 "1"s or 32 "0"s)
     */
    private String bool_as_bin32() {
        if (this.value) {
            return "11111111111111111111111111111111";
        } else {
            return "00000000000000000000000000000000";
        }
    }

    /**
     * Logical conjunction between a ScrabbleBool and ScrabbleBinary
     * Applies the boolean value to every digit of the ScrabbleBinary.
     * Via double dispatch with the ScrabbleBinary (commutative)
     * @param other_value ScrabbleBinary being operated.
     * @return new ScrabbleBinary with the resulting value.
     */
    public ScrabbleBinary and(ScrabbleBinary other_value) {
        // Double dispatch
        return other_value.and(new ScrabbleBinary(bool_as_bin32()));
    }

    /**
     * Logical disjunction between a ScrabbleBool and ScrabbleBinary
     * Applies the boolean value to every digit of the ScrabbleBinary.
     * Via double dispatch with the ScrabbleBinary (commutative)
     * @param other_value ScrabbleBinary being operated.
     * @return new ScrabbleBinary with the resulting value.
     */
    public ScrabbleBinary or(ScrabbleBinary other_value) {
        // Double dispatch
        return other_value.or(new ScrabbleBinary(bool_as_bin32()));
    }
}
