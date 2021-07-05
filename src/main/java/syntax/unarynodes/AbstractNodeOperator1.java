package syntax.unarynodes;

import syntax.INode;

/**
 * Abstract AST node type corresponding to a node with 2 children (binary node).
 */
public abstract class AbstractNodeOperator1 implements INode {
    // All binary nodes have 1 child node.
    protected final INode child;

    /**
     * Default constructor for a binary nodes, all it needs are the two child nodes.
     * @param val child node.
     */
    public AbstractNodeOperator1(INode val) {
        this.child = val;
    }
}
