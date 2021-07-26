package model.syntax.unarynodes;

import model.syntax.INode;

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

    /**
     * Functions for getting the number of children this node has.
     * @return int corresponding to number of children nodes.
     */
    public int get_children() {
        return 1;
    }

    /**
     * Method for returning the only child in this case
     * @return INode corresponidng to the child node
     */
    public INode get_child_a() {
        return this.child;
    }
}
