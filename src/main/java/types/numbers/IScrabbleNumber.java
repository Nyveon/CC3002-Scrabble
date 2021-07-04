package types.numbers;

/**
 * Interface defining common attributes of all scrabble number type variables
 */
public interface IScrabbleNumber {
    // All number types can convert to ScrabbleFloat
    ScrabbleFloat toScrabbleFloat();

    // --All number types can operate with the following--

    // All numeric operations with int
    IScrabbleNumber plus(ScrabbleInt other_value);
    IScrabbleNumber minus(ScrabbleInt other_value);
    IScrabbleNumber times(ScrabbleInt other_value);
    IScrabbleNumber div(ScrabbleInt other_value);

    // All numeric operations with binary
    IScrabbleNumber plus(ScrabbleBinary other_value);
    IScrabbleNumber minus(ScrabbleBinary other_value);
    IScrabbleNumber times(ScrabbleBinary other_value);
    IScrabbleNumber div(ScrabbleBinary other_value);

}
