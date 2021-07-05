package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

public class NodetoBinary extends AbstractNodeOperator1 {
    public NodetoBinary(INode val) {
        super(val);
    }

    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().toScrabbleBinary();
    }
}
