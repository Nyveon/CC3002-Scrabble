package types;

public interface IScrabbleVariable {
    String toString();

    IScrabbleVariable copy();

    int hashCode();

    boolean equals(Object other);

    ScrabbleString toScrabbleString(); //all convert to scrabble string
}
