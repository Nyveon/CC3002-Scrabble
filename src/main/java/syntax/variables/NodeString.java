package syntax.variables;

import syntax.INode;
import types.IScrabbleVariable;
import types.ScrabbleString;
import types.numbers.ScrabbleFloat;

public class NodeString implements INode {
    private final ScrabbleString variable;

    public NodeString(String val) {
        this.variable = new ScrabbleString(val);
    }

    @Override
    public ScrabbleString evaluate() {
        return this.variable;
    }
}
