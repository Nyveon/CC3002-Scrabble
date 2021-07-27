package model.types;

import cl.uchile.dcc.scrabble.gui.Scrabble;

/**
 * Singleton pattern null object scrabble variable type
 */
public class ScrabbleNull extends AbstractScrabbleVariable {
    private static ScrabbleNull instance = null;

    private ScrabbleNull() {

    }

    public static ScrabbleNull getInstance() {
        if (instance == null) {
            instance = new ScrabbleNull();
        }
        return instance;
    }

    @Override
    public IScrabbleVariable copy() {
        return null;
    }

    public String toString() {
        return "Null";
    }
}
