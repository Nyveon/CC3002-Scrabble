package syntax.unarynodes;

import syntax.INode;

public abstract class AbstractNodeOperator1 implements INode {
    protected final INode child;

    public AbstractNodeOperator1(INode val) {
        this.child = val;
    }
}
