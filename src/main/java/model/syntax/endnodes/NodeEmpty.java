package model.syntax.endnodes;

import model.types.IScrabbleVariable;
import model.types.ScrabbleNull;

/**
 * Childless node type (end node)
 * Placeholder node. DOES NOT EVALUATE!
 */
public class NodeEmpty extends AbstractNode0 {
    @Override
    public int get_shape() {
        return -1;
    }

    public String get_label() {
        return "Click to \n change";
    }

    @Override
    public IScrabbleVariable evaluate() {
        return ScrabbleNull.getInstance();
    }

    /**
     * This node is the only editable one
     * @return
     */
    @Override
    public boolean editable() {
        return true;
    }
}
