package syntax.variables;

import syntax.INode;
import types.ScrabbleBool;
import types.numbers.ScrabbleBinary;

public class NodeBinary implements INode {
    private final ScrabbleBinary variable;

    public NodeBinary(String val) {
        this.variable = new ScrabbleBinary(val);
    }

    @Override
    public ScrabbleBinary evaluate() {
        return this.variable;
    }
}
