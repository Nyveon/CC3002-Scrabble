package types;

import java.util.Objects;

/**
 * Class defining common methods of all scrabble variables
 */
public abstract class AbstractScrabbleVariable implements IScrabbleVariable{
    /**
     * Convert any ScrabbleVariable to ScrabbleString.
     * @return ScrabbleString made with the string cast of the value
     */
    public ScrabbleString toScrabbleString() {
        return new ScrabbleString(toString());
    }
}
