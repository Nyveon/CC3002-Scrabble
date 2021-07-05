package syntax.binarynodes.operators;

import syntax.INode;
import syntax.binarynodes.AbstractNodeOperator2;
import types.IScrabbleVariable;

public class NodeAnd extends AbstractNodeOperator2 {

    public NodeAnd(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return left.evaluate().and(right.evaluate());
    }
}
