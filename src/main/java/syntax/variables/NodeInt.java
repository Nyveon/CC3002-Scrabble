package syntax.variables;

import syntax.INode;
import types.IScrabbleVariable;
import types.ScrabbleString;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

public class NodeInt implements INode {
    private final ScrabbleInt variable;

    public NodeInt(int val) {
        this.variable = new ScrabbleInt(val);
    }

    @Override
    public ScrabbleInt evaluate() {
        return this.variable;
    }
}
