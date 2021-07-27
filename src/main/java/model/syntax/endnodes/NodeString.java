package model.syntax.endnodes;

import model.syntax.INode;
import model.types.ScrabbleString;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleString variable.
 */
public class NodeString extends AbstractNode0 {
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

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return this.variable.toString();
    }
}
