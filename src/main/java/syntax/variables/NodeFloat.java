package syntax.variables;

import syntax.INode;
import types.numbers.ScrabbleFloat;
import types.numbers.ScrabbleInt;

public class NodeFloat implements INode {
    private final ScrabbleFloat variable;

    public NodeFloat(double val) {
        this.variable = new ScrabbleFloat(val);
    }

    @Override
    public ScrabbleFloat evaluate() {
        return this.variable;
    }
}
