package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

public class NodetoString extends AbstractNodeOperator1 {
    public NodetoString(INode val) {
        super(val);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().toScrabbleString();
    }
}
