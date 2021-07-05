package types;

/**
 * Interface defining common attributes of all scrabble variables
 */
public interface IScrabbleVariable {
    // All types convert to themselves -> All types require a way to copy themselves
    IScrabbleVariable copy();

    // Testing functions
    @Override int hashCode();
    @Override boolean equals(Object obj);

    // All types can convert to ScrabbleString
    @Override String toString();
    ScrabbleString toScrabbleString();

    IScrabbleVariable plus(IScrabbleVariable other_value);
    IScrabbleVariable minus(IScrabbleVariable other_value);
    IScrabbleVariable times(IScrabbleVariable other_value);
    IScrabbleVariable div(IScrabbleVariable other_value);
    IScrabbleVariable and(IScrabbleVariable other_value);
    IScrabbleVariable or(IScrabbleVariable other_value);
    IScrabbleVariable not();

    IScrabbleVariable toScrabbleBool();
    IScrabbleVariable toScrabbleFloat();
    IScrabbleVariable toScrabbleInt();
    IScrabbleVariable toScrabbleBinary();
}
