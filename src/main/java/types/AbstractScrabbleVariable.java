package types;

import types.numbers.ScrabbleBinary;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

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

    //----------------------------------------------

    // Ok, se que esto est mal pero como ya pas la tarea 1 supongo que est bien hacerlo
    // El punto de este codigo es un shortcut para el double dispatch de la maqueta, que si soy
    // completamente honesto, no lo entendi.

    //---------------------------------------------
    /**
     * Operation validity checker functions
     * @param other_value the value being operated with
     * @return null if an invalid operation, the operation reuslt if it is valid
     */
    @Override
    public IScrabbleVariable plus(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleInt) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleInt) this).plus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleInt) this).plus(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleInt) this).plus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Floats
        if (this instanceof ScrabbleFloat) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleFloat) this).plus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleFloat) this).plus(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleFloat) this).plus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Binary
        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleBinary) this).plus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).plus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Bool

        // String

        return null;
    }

    @Override
    public IScrabbleVariable minus(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleInt) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleInt) this).minus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleInt) this).minus(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleInt) this).minus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Floats
        if (this instanceof ScrabbleFloat) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleFloat) this).minus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleFloat) this).minus(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleFloat) this).minus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Binary
        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleBinary) this).minus(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).minus(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Bool

        // String

        return null;
    }

    @Override
    public IScrabbleVariable times(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleInt) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleInt) this).times(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleInt) this).times(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleInt) this).times(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Floats
        if (this instanceof ScrabbleFloat) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleFloat) this).times(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleFloat) this).times(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleFloat) this).times(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Binary
        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleBinary) this).times(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).times(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Bool

        // String

        return null;
    }

    @Override
    public IScrabbleVariable div(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleInt) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleInt) this).div(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleInt) this).div(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleInt) this).div(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Floats
        if (this instanceof ScrabbleFloat) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleFloat) this).div(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleFloat) {
                return ((ScrabbleFloat) this).div(((ScrabbleFloat) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleFloat) this).div(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Binary
        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleInt) {
                return ((ScrabbleBinary) this).div(((ScrabbleInt) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).div(((ScrabbleBinary) other_value));
            } else {
                return null;
            }
        }

        // Bool

        // String

        return null;
    }

    @Override
    public IScrabbleVariable and(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleBool) {
            if (other_value instanceof ScrabbleBool) {
                return ((ScrabbleBool) this).and(((ScrabbleBool) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBool) this).and(((ScrabbleBinary) other_value));
            }
        }

        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleBool) {
                return ((ScrabbleBinary) this).and(((ScrabbleBool) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).and(((ScrabbleBinary) other_value));
            }
        }
        return null;
    }

    @Override
    public IScrabbleVariable or(IScrabbleVariable other_value) {
        // Ints
        if (this instanceof ScrabbleBool) {
            if (other_value instanceof ScrabbleBool) {
                return ((ScrabbleBool) this).or(((ScrabbleBool) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBool) this).or(((ScrabbleBinary) other_value));
            }
        }

        if (this instanceof ScrabbleBinary) {
            if (other_value instanceof ScrabbleBool) {
                return ((ScrabbleBinary) this).or(((ScrabbleBool) other_value));
            } else if (other_value instanceof ScrabbleBinary) {
                return ((ScrabbleBinary) this).or(((ScrabbleBinary) other_value));
            }
        }
        return null;
    }

    @Override
    public IScrabbleVariable not() {
        if (this instanceof ScrabbleBool) {
            return ((ScrabbleBool) this).not();
        } else if (this instanceof ScrabbleBinary) {
            return ((ScrabbleBinary) this).not();
        }

        return null;
    }

    @Override
    public IScrabbleVariable toScrabbleBool() {
        if (this instanceof ScrabbleBool) {
            return ((ScrabbleBool) this).toScrabbleBool();
        }

        return null;
    }

    @Override
    public IScrabbleVariable toScrabbleFloat() {
        if (this instanceof ScrabbleFloat) {
            return ((ScrabbleFloat) this).toScrabbleFloat();
        } else if (this instanceof ScrabbleInt) {
            return ((ScrabbleInt) this).toScrabbleFloat();
        } else if (this instanceof ScrabbleBinary) {
            return ((ScrabbleBinary) this).toScrabbleFloat();
        }

        return null;
    }

    @Override
    public IScrabbleVariable toScrabbleInt() {
        if (this instanceof ScrabbleInt) {
            return ((ScrabbleInt) this).toScrabbleInt();
        } else if (this instanceof ScrabbleBinary) {
            return ((ScrabbleBinary) this).toScrabbleInt();
        }

        return null;
    }

    @Override
    public IScrabbleVariable toScrabbleBinary() {
        if (this instanceof ScrabbleInt) {
            return ((ScrabbleInt) this).toScrabbleBinary();
        } else if (this instanceof ScrabbleBinary) {
            return ((ScrabbleBinary) this).toScrabbleBinary();
        }

        return null;
    }
}
