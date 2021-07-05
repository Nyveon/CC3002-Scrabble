package syntax.operators;

import syntax.INode;

public abstract class AbstractNodeOperator {
    INode left;
    INode right;

    public AbstractNodeOperator(INode val_left, INode val_right) {
        this.left = val_left;
        this.right = val_right;
    }

}
