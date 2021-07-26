package model.syntax.binarynodes;

import model.syntax.INode;

/**
 * Abstract AST node type corresponding to a node with 2 children (binary node).
 */
public abstract class AbstractNodeOperator2 implements INode {
    // All binary nodes have 2 children nodes.
    protected final INode left;
    protected final INode right;

    /**
     * Default constructor for a binary nodes, all it needs are the two child nodes.
     * @param val_left left node.
     * @param val_right right node.
     */
    public AbstractNodeOperator2(INode val_left, INode val_right) {
        this.left = val_left;
        this.right = val_right;
    }

    /**
     * Functions for getting the number of children this node has.
     * @return int corresponding to number of children nodes.
     */
    public int get_children() {
        return 2;
    }

    /**
     * Method for returning the left child in this case
     * @return INode corresponidng to the left child node
     */
    public INode get_child_a() {
        return this.left;
    }

    /**
     * Method for returning the left child in this case
     * @return INode corresponidng to the right child node
     */
    public INode get_child_b() {
        return this.right;
    }
}
