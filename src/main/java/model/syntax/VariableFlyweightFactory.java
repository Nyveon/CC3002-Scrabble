package model.syntax;

import model.types.IScrabbleVariable;
import model.types.ScrabbleBool;
import model.types.ScrabbleString;
import model.types.numbers.ScrabbleBinary;
import model.types.numbers.ScrabbleFloat;
import model.types.numbers.ScrabbleInt;

import java.util.HashMap;

/**
 * Flyweight object for optimizing memory usage of ScrabbleVariables
 */
public class VariableFlyweightFactory {
    static HashMap<String, IScrabbleVariable> variables = new HashMap<String, IScrabbleVariable>();

    // nota a ayudante: no alcancé a hacer esto para los nodes T_T

    /**
     * Getter. Returns variable with given name. Null if variable does not exist.
     * @param name String name of variable
     * @return null if not in hashmap. ScrabbleVariable object if it exists.
     */
    static IScrabbleVariable getVariable(String name) {
        return variables.get(name);
    }

    /**
     * Flyweight factory for ScrabbleString
     * @param name Name of the variable
     * @param value Value of the variable
     * @return Resulting variable (New if not previously made, pre-existing if exists)
     */
    static ScrabbleString createScrabbleString(String name, String value) {
        ScrabbleString result = (ScrabbleString) variables.get(name);
        if (result == null) {
            result = new ScrabbleString(value);
            variables.put(name, result);
        }
        return result;
    }

    /**
     * Flyweight factory for ScrabbleBool
     * @param name Name of the variable
     * @param value Value of the variable
     * @return Resulting variable (New if not previously made, pre-existing if exists)
     */
    static ScrabbleBool createScrabbleBool(String name, boolean value) {
        ScrabbleBool result = (ScrabbleBool) variables.get(name);
        if (result == null) {
            result = new ScrabbleBool(value);
            variables.put(name, result);
        }
        return result;
    }

    /**
     * Flyweight factory for ScrabbleFloat
     * @param name Name of the variable
     * @param value Value of the variable
     * @return Resulting variable (New if not previously made, pre-existing if exists)
     */
    static ScrabbleFloat createScrabbleFloat(String name, double value) {
        ScrabbleFloat result = (ScrabbleFloat) variables.get(name);
        if (result == null) {
            result = new ScrabbleFloat(value);
            variables.put(name, result);
        }
        return result;
    }

    /**
     * Flyweight factory for ScrabbleInt
     * @param name Name of the variable
     * @param value Value of the variable
     * @return Resulting variable (New if not previously made, pre-existing if exists)
     */
    static ScrabbleInt createScrabbleInt(String name, int value) {
        ScrabbleInt result = (ScrabbleInt) variables.get(name);
        if (result == null) {
            result = new ScrabbleInt(value);
            variables.put(name, result);
        }
        return result;
    }

    /**
     * Flyweight factory for ScrabbleBinary
     * @param name Name of the variable
     * @param value Value of the variable
     * @return Resulting variable (New if not previously made, pre-existing if exists)
     */
    static ScrabbleBinary createScrabbleBinary(String name, String value) {
        ScrabbleBinary result = (ScrabbleBinary) variables.get(name);
        if (result == null) {
            result = new ScrabbleBinary(value);
            variables.put(name, result);
        }
        return result;
    }

}
