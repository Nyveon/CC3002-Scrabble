package syntax.binarynodes.operators;

import syntax.INode;
import syntax.binarynodes.AbstractNodeOperator2;
import types.IScrabbleVariable;

public class NodeDiv extends AbstractNodeOperator2 {

    public NodeDiv(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return left.evaluate().div(right.evaluate());
    }
}
