package syntax.unarynodes.variables;

import syntax.INode;
import types.ScrabbleBool;
import types.ScrabbleString;

public class NodeBool implements INode {
    private final ScrabbleBool variable;

    public NodeBool(boolean val) {
        this.variable = new ScrabbleBool(val);
    }

    @Override
    public ScrabbleBool evaluate() {
        return this.variable;
    }
}
