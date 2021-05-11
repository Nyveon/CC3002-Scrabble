package types;

/**
 * Scrabble variable which encapsulates a java double.
 * Interestingly called a float?
 */
public class ScrabbleFloat extends AbstractScrabbleNumber {
    private double value;

    // ------<Primary functions>------
    /**
     * Create a ScrabbleFloat Scrabble variable.
     * @param val A java double.
     */
    public ScrabbleFloat(double val) {
        this.value = val;
    }

    /**
     * Procures the value of the variable.
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


    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }

    public ScrabbleFloat toScrabbleFloat() {
        return copy();
    }
}
