package model.syntax.binarynodes.operators;

import model.syntax.INode;
import model.syntax.binarynodes.AbstractNodeOperator2;
import model.types.IScrabbleVariable;
import model.types.ScrabbleNull;

/**
 * AST Node that holds two values, and applies the "div" operator to them
 */
public class NodeDiv extends AbstractNodeOperator2 {
    /**
     * Normal constructor, inherits from abstract binary node type.
     * @param val_left Left child node.
     * @param val_right Right child node.
     */
    public NodeDiv(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    /**
     * Evaluation of both children nodes, corresponds to the "div" operation
     * of the evaluation of both children.
     * @return IScrabbleVariable corresponding to the results of the operation. null if invalid operation.
     */
    @Override
    public IScrabbleVariable evaluate() {
        try {
            return left.evaluate().div(right.evaluate());
        } catch (ArithmeticException e){
            return ScrabbleNull.getInstance();
        }
    }

    /**
     * Method that returns the text label of this node for the view.
     * @return string.
     */
    @Override
    public String get_label() {
        return "/";
    }
}
