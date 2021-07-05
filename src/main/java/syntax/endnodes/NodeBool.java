package syntax.endnodes;

import syntax.INode;
import types.ScrabbleBool;
import types.ScrabbleString;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleBool variable.
 */
public class NodeBool implements INode {
    // Node's value
    private final ScrabbleBool variable;

    /**
     * Constructor for the node
     * @param val ScrabbleBool variable
     */
    public NodeBool(boolean val) {
        this.variable = new ScrabbleBool(val);
    }

    /**
     * Evaluation returns the value of the node.
     * @return ScrabbleBool variable
     */
    @Override
    public ScrabbleBool evaluate() {
        return this.variable;
    }
}
