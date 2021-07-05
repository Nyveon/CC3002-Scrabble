package syntax.unarynodes.operators;

import syntax.INode;
import syntax.unarynodes.AbstractNodeOperator1;
import types.IScrabbleVariable;

/**
 * AST Node that holds one values, and applies the "toScrabbleFloat" conversion operator to it.
 */
public class NodetoFloat extends AbstractNodeOperator1 {
    /**
     * Normal constructor, inherits form abstract unary node type.
     * @param val child node
     */
    public NodetoFloat(INode val) {
        super(val);
    }

    /**
     * Operates the evaluation of the child node with the "toScrabbleFloat" conversion operator.
     * @return IScrabbleVariable corresponding to the result of the operation. null if invalid operation.
     */
    @Override
    public IScrabbleVariable evaluate() {
        return child.evaluate().toScrabbleFloat();
    }
}
