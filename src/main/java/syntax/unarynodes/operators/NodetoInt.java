package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

public class NodetoInt extends AbstractNodeOperator1 {
    public NodetoInt(INode val) {
        super(val);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().toScrabbleInt();
    }
}
