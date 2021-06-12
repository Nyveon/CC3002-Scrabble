package types;

import java.util.Objects;

/**
 * Scrabble variable which encapsulates a java string, representing a number in binary.
 * MUST BE LENGTH 32 WITH LEADING 0s!
 * ^ Doesn't actually have to be, but it will automatically be converted to one!
 */
public class ScrabbleBinary extends AbstractScrabbleVariable implements IScrabbleBinaries, IScrabbleNumber {
    private final String value;


    // ------<Primary functions>------
    /**
     * Create a ScrabbleBinary Scrabble variable.
     * @param val A java string.
     */
    public ScrabbleBinary(String val) {
        // Add leading 0s, just in case
        int n = val.length();
        StringBuilder valBuilder = new StringBuilder(val);
        for (int i = n; i < 32; i++) {
            valBuilder.insert(0, "0");
        }
        val = valBuilder.toString();
        this.value = val;
    }

    /**
     * Procures the value of the variable.
     * Overrides Object toString.
     * @return Value as a java string.
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Copies the object.
     * @return identical copy ScrabbleBinary.
     */
    public ScrabbleBinary copy() {
        return new ScrabbleBinary(value);
    }

    // ------<Getters and setters>------

    /**
     * Getter for the main value of the scrabble variable.
     * @return value of the variable, as the corresponding java variable type.
     */
    String getValue() {
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
        ScrabbleBinary that = (ScrabbleBinary) o;
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


    // ------<Conversions>------
    /**
     * Convert ScrabbleBinary to ScrabbleBinary.
     * @return copy of the original ScrabbleInt.
     */
    public ScrabbleBinary toScrabbleBinary() {
        return copy();
    }

    /**
     * Auxiliary function to convert a single character ('0' or '1) to an integer (0 or 1)
     * @param bit character.
     * @return int (0 or 1)
     */
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * Converts a negative binary string to an integer.
     * @param binary as String value.
     * @return int corresponding to the conversion.
     */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w - 1; //agregué un -1 aqui para que funcionara
    }

    /**
     * Converts a positive binary string to an integer.
     * @param binary as String value.
     * @return int corresponding to the conversion.
     */
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Converts a binary string to an integer.
     * @param binary as String value.
     * @return int corresponding to the conversion.
     */
    public int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Convert ScrabbleBinary to ScrabbleInt.
     * @return integer interpretation of the binary number.
     */
    public ScrabbleInt toScrabbleInt() {
        return new ScrabbleInt(toInt(this.value));
    }

    /**
     * Convert ScrabbleBinary to ScrabbleFloat.
     * @return float interpretation of the binary number.
     */
    public ScrabbleFloat toScrabbleFloat() {
        // Pass through int first, then to float
        return new ScrabbleFloat(toInt(this.value));
    }

    // ------<Arithmetic Operations>------
    // -- With Int --

    /**
     * Method to add a ScrabbleBinary with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary plus(ScrabbleInt other_value) {
        return new ScrabbleInt(toInt(this.value) + other_value.getValue()).toScrabbleBinary();
    }

    /**
     * Method to subtract a ScrabbleBinary with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary minus(ScrabbleInt other_value) {
        return new ScrabbleInt(toInt(this.value) - other_value.getValue()).toScrabbleBinary();
    }

    /**
     * Method to multiply a ScrabbleBinary with a ScrabbleInt
     * @param other_value ScrabbleInt object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary times(ScrabbleInt other_value) {
        return new ScrabbleInt(toInt(this.value) * other_value.getValue()).toScrabbleBinary();
    }

    /**
     * Method to divide a ScrabbleBinary with a ScrabbleInt
     * @param other_value ScrabbleInt object to be added.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary div(ScrabbleInt other_value) {
        return new ScrabbleInt(toInt(this.value) / other_value.getValue()).toScrabbleBinary();
    }

    // -- With Binary --
    /**
     * Method to add a ScrabbleBinary with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary plus(ScrabbleBinary other_value) {
        return new ScrabbleInt((toInt(this.value) + toInt(other_value.getValue()))).toScrabbleBinary();
    }

    /**
     * Method to subtract a ScrabbleBinary with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary minus(ScrabbleBinary other_value) {
        return new ScrabbleInt((toInt(this.value) - toInt(other_value.getValue()))).toScrabbleBinary();
    }

    /**
     * Method to multiply a ScrabbleBinary with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary times(ScrabbleBinary other_value) {
        return new ScrabbleInt((toInt(this.value) * toInt(other_value.getValue()))).toScrabbleBinary();
    }

    /**
     * Method to divide a ScrabbleBinary with a ScrabbleBinary
     * @param other_value ScrabbleBinary object to be operated with.
     * @return new ScrabbleBinary with resulting value.
     */
    @Override
    public ScrabbleBinary div(ScrabbleBinary other_value) {
        return new ScrabbleInt(toInt(this.value) / toInt(other_value.getValue())).toScrabbleBinary();
    }

    /**
     * Creates a new scrabble bool with the opposite of the value.
     * Iterates character by character, flipping the value.
     * @return ScrabbleBool with new value.
     */
    public ScrabbleBinary not() {
        StringBuilder new_string = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (this.value.charAt(i) == '0') {
                new_string.append('1');
            } else {
                new_string.append('0');
            }
        }
        return new ScrabbleBinary(new_string.toString());
    }

    // With ScrabbleBool

    /**
     * Logical conjunction with a ScrabbleBool
     * Applies the ScrabbleBool to every value of this Binary.
     * Double Dispatch to the ScrabbleBool.
     * @param other_value ScrabbleBool
     * @return ScrabbleBinary with the resulting value.
     */
    @Override
    public ScrabbleBinary and(ScrabbleBool other_value) {
        return other_value.and(this);
    }

    /**
     * Logical disjunction with a ScrabbleBool
     * Applies the ScrabbleBool to every value of this Binary.
     * Double Dispatch to the ScrabbleBool.
     * @param other_value ScrabbleBool
     * @return ScrabbleBinary with the resulting value.
     */
    @Override
    public ScrabbleBinary or(ScrabbleBool other_value) {
        return other_value.or(this);
    }

    // With ScrabbleBinary

    /**
     * Logical conjunction with another ScrabbleBinary.
     * Compares index by index, each value of the Binary String.
     * @param other_value Other ScrabbleBinary being operated with.
     * @return ScrabbleBinary with the resulting value.
     */
    @Override
    public ScrabbleBinary and(ScrabbleBinary other_value) {
        StringBuilder new_string = new StringBuilder();
        for (int i = 0; i <32; i++) {
            if (this.value.charAt(i) == '1' && other_value.getValue().charAt(i) == '1') {
                new_string.append('1');  // Case 1 AND 1.
            } else {
                new_string.append('0');  //Cases 0 AND 0, 0 AND 1, 1 AND 0.
            }
        }
        return new ScrabbleBinary(new_string.toString());
    }

    /**
     * Logical disjunction with another ScrabbleBinary.
     * Compares index by index, each value of the Binary String.
     * @param other_value Other ScrabbleBinary being operated with.
     * @return ScrabbleBinary with the resulting value.
     */
    @Override
    public ScrabbleBinary or(ScrabbleBinary other_value) {
        StringBuilder new_string = new StringBuilder();
        for (int i = 0; i <32; i++) {
            if (this.value.charAt(i) == '0' && other_value.getValue().charAt(i) == '0') {
                new_string.append('0');  // Case 0 AND 0.
            } else {
                new_string.append('1');  //Cases 1 AND 1, 0 AND 1, 1 AND 0.
            }
        }
        return new ScrabbleBinary(new_string.toString());
    }




}
