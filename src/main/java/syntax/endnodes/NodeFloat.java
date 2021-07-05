package syntax.endnodes;

import syntax.INode;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleFloat variable.
 */
public class NodeFloat implements INode {
    // Node's value
    private final ScrabbleFloat variable;

    /**
     * Constructor for the node
     * @param val ScrabbleFloat variable
     */
    public NodeFloat(double val) {
        this.variable = new ScrabbleFloat(val);
    }

    /**
     * Evaluation returns the value of the node.
     * @return ScrabbleFloat variable
     */
    @Override
    public ScrabbleFloat evaluate() {
        return this.variable;
    }
}
