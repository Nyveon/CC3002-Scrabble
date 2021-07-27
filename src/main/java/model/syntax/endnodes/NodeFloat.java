package model.syntax.endnodes;

import model.syntax.INode;
import model.types.numbers.ScrabbleFloat;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleFloat variable.
 */
public class NodeFloat extends AbstractNode0 {
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

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return this.variable.toString();
    }
}
