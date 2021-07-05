package syntax.binarynodes;

import syntax.INode;

public abstract class AbstractNodeOperator2 implements INode {
    protected final INode left;
    protected final INode right;

    public AbstractNodeOperator2(INode val_left, INode val_right) {
        this.left = val_left;
        this.right = val_right;
    }
}
