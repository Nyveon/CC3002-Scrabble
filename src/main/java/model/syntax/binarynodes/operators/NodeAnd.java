package model.syntax.binarynodes.operators;

import model.syntax.INode;
import model.syntax.binarynodes.AbstractNodeOperator2;
import model.types.IScrabbleVariable;

/**
 * AST Node that holds two values, and applies the "and" operator to them
 */
public class NodeAnd extends AbstractNodeOperator2 {
    /**
     * Normal constructor, inherits from abstract binary node type.
     * @param val_left Left child node.
     * @param val_right Right child node.
     */
    public NodeAnd(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    /**
     * Evaluation of both children nodes, corresponds to the "and" operation
     * of the evaluation of both children.
     * @return IScrabbleVariable corresponding to the results of the operation. null if invalid operation.
     */
    @Override
    public IScrabbleVariable evaluate() {
        return left.evaluate().and(right.evaluate());
    }

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return "AND";
    }
}
