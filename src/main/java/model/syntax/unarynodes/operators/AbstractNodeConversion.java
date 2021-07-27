package model.syntax.unarynodes.operators;

import model.syntax.INode;
import model.syntax.unarynodes.AbstractNodeOperator1;

/**
 * Abstract AST node type corresponding to a type conversion node
 */
public abstract class AbstractNodeConversion extends AbstractNodeOperator1 {

    /**
     * Default constructor for a binary nodes, all it needs are the two child nodes.
     *
     * @param val child node.
     */
    public AbstractNodeConversion(INode val) {
        super(val);
    }

    /**
     * Shape for visualization. In this case, a downwards pointing triangle/arrow/pentagon thing
     * @return 3.
     */
    @Override
    public int get_shape() {
        return 3;
    }
}
