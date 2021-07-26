package model.syntax.endnodes;

import model.syntax.INode;
import model.types.ScrabbleBool;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleBool variable.
 */
public class NodeBool extends AbstractNode0 {
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

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return this.variable.toString();
    }
}
