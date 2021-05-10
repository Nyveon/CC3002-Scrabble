package types;

public class ScrabbleBool {
    private boolean value;

    public ScrabbleBool(boolean val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    public ScrabbleBool copy() {
        return new ScrabbleBool(value);
    }

    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }

    public ScrabbleBool toScrabbleBool() {
        return copy();
    }
}
