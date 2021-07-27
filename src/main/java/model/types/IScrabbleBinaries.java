package model.types;

import model.types.numbers.ScrabbleBinary;

/**
 * Interface that defines behaviours all binary type data shares.
 */
public interface IScrabbleBinaries {
    // Logical negation
    IScrabbleBinaries not();

    // Logical operations with ScrabbleBools
    IScrabbleBinaries and(ScrabbleBool other_value);
    IScrabbleBinaries or(ScrabbleBool other_value);

    // Logical operations with ScrabbleBinaries
    IScrabbleBinaries and(ScrabbleBinary other_value);
    IScrabbleBinaries or(ScrabbleBinary other_value);
}