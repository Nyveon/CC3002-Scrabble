package model.syntax.unarynodes;

import model.syntax.INode;
import model.syntax.endnodes.NodeEmpty;

/**
 * Abstract AST node type corresponding to a node with 2 children (binary node).
 */
public abstract class AbstractNodeOperator1 implements INode {
    // All binary nodes have 1 child node.
    protected INode child;

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

    /**
     * Delete child if it is the target, otherwise postorder to child.
     * @param node Target for deletion
     */
    @Override
    public void delete(INode node) {
        if (child == node) {
            child = new NodeEmpty();
        } else {
            child.delete(node);
        }
    }

    /**
     * Insert new child if it is the target, otherwise postorder to child.
     * @param node Target for deletion
     */
    @Override
    public void insert(INode target_node, INode insertion_node) {
        if (child == target_node) {
            child = insertion_node;
        } else {
            child.insert(target_node, insertion_node);
        }
    }
}
