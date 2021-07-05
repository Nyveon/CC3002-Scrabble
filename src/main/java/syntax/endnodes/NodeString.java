package syntax.endnodes;

import syntax.INode;
import types.IScrabbleVariable;
import types.ScrabbleString;
import types.numbers.ScrabbleFloat;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleString variable.
 */
public class NodeString implements INode {
    // Node's value
    private final ScrabbleString variable;

    /**
     * Constructor for the node
     * @param val ScrabbleString variable
     */
    public NodeString(String val) {
        this.variable = new ScrabbleString(val);
    }

    /**
     * Evaluation returns the value of the node.
     * @return ScrabbleString variable
     */
    @Override
    public ScrabbleString evaluate() {
        return this.variable;
    }
}
