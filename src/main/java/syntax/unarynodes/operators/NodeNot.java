package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

public class NodeNot extends AbstractNodeOperator1 {
    public NodeNot(INode val) {
        super(val);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().not();
    }
}
