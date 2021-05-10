package types;

public class ScrabbleInt implements IScrabbleNumber {
    private int value;

    public ScrabbleInt(int val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public ScrabbleInt copy() {
        return new ScrabbleInt(value);
    }

    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(this.toString());
    }

    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat((float) this.value);
    }

    public ScrabbleInt toScrabbleInt() {
        return copy();
    }

    public ScrabbleBinary toScrabbleBinary() {
        return null;
    }
}
