package syntax.binarynodes.operators;

import syntax.INode;
import syntax.binarynodes.AbstractNodeOperator2;
import types.IScrabbleVariable;

/**
 * AST Node that holds two values, and applies the "plus" operator to them
 */
public class NodePlus extends AbstractNodeOperator2 {
    /**
     * Normal constructor, inherits from abstract binary node type.
     * @param val_left Left child node.
     * @param val_right Right child node.
     */
    public NodePlus(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    /**
     * Evaluation of both children nodes, corresponds to the "plus" operation
     * of the evaluation of both children.
     * @return IScrabbleVariable corresponding to the results of the operation. null if invalid operation.
     */
    @Override
    public IScrabbleVariable evaluate() {
        return left.evaluate().plus(right.evaluate());
    }
}
