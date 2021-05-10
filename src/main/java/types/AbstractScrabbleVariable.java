package types;

import java.util.Objects;

/**
 * Class defining common methods of all scrabble variables
 */
public abstract class AbstractScrabbleVariable implements IScrabbleVariable{

    /**
     * Overrides Object hashCode.
     * @return hash of the class as an integer.
     */
    @Override public int hashCode() {
        return Objects.hash(AbstractScrabbleVariable.class);
    }
}
