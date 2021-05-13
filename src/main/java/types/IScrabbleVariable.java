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
}
