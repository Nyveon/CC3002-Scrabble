package syntax.endnodes;

import syntax.INode;
import types.ScrabbleBool;
import types.numbers.ScrabbleBinary;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleBinary variable.
 */
public class NodeBinary implements INode {
    // Node's value
    private final ScrabbleBinary variable;

    /**
     * Constructor for the node
     * @param val ScrabbleBinary variable
     */
    public NodeBinary(String val) {
        this.variable = new ScrabbleBinary(val);
    }

    /**
     * Evaluation returns the value of the node.
     * @return ScrabbleBinary variable
     */
    @Override
    public ScrabbleBinary evaluate() {
        return this.variable;
    }
}
