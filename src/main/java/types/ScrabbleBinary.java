package types;

public class ScrabbleBinary implements IScrabbleNumber{
    private String value;

    public ScrabbleBinary(String val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return value;
    }

    public ScrabbleBinary copy() {
        return new ScrabbleBinary(value);
    }

    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(value);
    }

    public ScrabbleFloat toScrabbleFloat() {
        return null;
    }

    public ScrabbleInt toScrabbleInt() {
        return null;
    }

    public ScrabbleBinary toScrabbleBinary() {
        return copy();
    }
}
