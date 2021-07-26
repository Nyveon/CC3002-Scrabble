package model.syntax.endnodes;

import model.syntax.INode;
import model.types.numbers.ScrabbleBinary;

/**
 * Childless node type (end node)
 * Holds a value corresponding to a ScrabbleBinary variable.
 */
public class NodeBinary extends AbstractNode0 {
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

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return this.variable.toString().replaceFirst("^0*", ""); // replace all leading 0s
    }
}
