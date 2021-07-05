package syntax.binarynodes.operators;

import syntax.INode;
import syntax.binarynodes.AbstractNodeOperator2;
import types.IScrabbleVariable;

public class NodePlus extends AbstractNodeOperator2 {

    public NodePlus(INode val_left, INode val_right) {
        super(val_left, val_right);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return left.evaluate().plus(right.evaluate());
    }
}
