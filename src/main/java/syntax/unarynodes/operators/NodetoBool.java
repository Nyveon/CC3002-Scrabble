package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

public class NodetoBool extends AbstractNodeOperator1 {
    public NodetoBool(INode val) {
        super(val);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().toScrabbleBool();
    }
}
