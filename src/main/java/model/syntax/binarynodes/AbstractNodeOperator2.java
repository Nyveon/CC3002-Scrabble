package model.syntax.binarynodes;

import model.syntax.INode;
import model.syntax.endnodes.NodeEmpty;

/**
 * Abstract AST node type corresponding to a node with 2 children (binary node).
 */
public abstract class AbstractNodeOperator2 implements INode {
    // All binary nodes have 2 children nodes.
    protected INode left;
    protected INode right;

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

    /**
     * Delete either child if it is the target, otherwise postorder to children.
     * @param node Target for deletion
     */
    @Override
    public void delete(INode node) {
        if (left == node) {
            this.left = new NodeEmpty();
        } else if (right == node) {
            this.right = new NodeEmpty();
        } else {
            this.left.delete(node);
            this.right.delete(node);
        }
    }


    /**
     * Insert node if it corresponds
     * @param target_node
     * @param insertion_node
     */
    @Override
    public void insert(INode target_node, INode insertion_node) {
        if (this.left == target_node) {
            this.left = insertion_node;
        } else if (this.right == target_node) {
            this.right = insertion_node;
        } else {
            this.left.insert(target_node, insertion_node);
            this.right.insert(target_node, insertion_node);
        }
    }
}
