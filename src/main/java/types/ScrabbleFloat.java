package types;

/*  Scrabble type: Float
    Holds a java float */
public class ScrabbleFloat implements IScrabbleNumber{
    private float value;

    public ScrabbleFloat(float val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }

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
