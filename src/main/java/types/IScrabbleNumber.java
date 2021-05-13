package types;

/**
 * Interface defining common attributes of all scrabble number type variables
 */
public interface IScrabbleNumber {
    // All number types can convert to ScrabbleFloat
    ScrabbleFloat toScrabbleFloat();
}
