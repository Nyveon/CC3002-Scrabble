package model.syntax.endnodes;

import model.syntax.INode;
import model.types.numbers.ScrabbleInt;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleInt variable.
 */
public class NodeInt extends AbstractNode0 {
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

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return this.variable.toString();
    }
}
