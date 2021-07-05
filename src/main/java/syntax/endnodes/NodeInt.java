package syntax.endnodes;

import syntax.INode;
import types.IScrabbleVariable;
import types.ScrabbleString;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleInt variable.
 */
public class NodeInt implements INode {
    // Node's value
    private final ScrabbleInt variable;

    /**
     * Constructor for the node
     * @param val ScrabbleInt variable
     */
    public NodeInt(int val) {
        this.variable = new ScrabbleInt(val);
    }

    /**
     * Evaluation returns the value of the node.
     * @return ScrabbleInt variable
     */
    @Override
    public ScrabbleInt evaluate() {
        return this.variable;
    }
}
