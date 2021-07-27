package model.syntax.endnodes;

import model.syntax.INode;
import model.types.IScrabbleVariable;


/**
 * Abstract AST node type corresponding to a node with 0 children (end node).
 */
public abstract class AbstractNode0 implements INode {
    /**
     * Functions for getting the number of children this node has.
     * @return int corresponding to number of children nodes.
     */
    public int get_children() {
        return 0;
    }

    /**
     * End nodes are always boxes
     * @return 1 (pseud-enum for rounded rect)
     */
    public int get_shape() {
        return 1;
    }


    /**
     * Leaf nodes can't be deleted
     * @param node Target for deletion
     */
    @Override
    public void delete(INode node) { }

    /**
     * Leaf nodes can't insert.
     * @param target_node
     * @param insertion_node
     */
    public void insert(INode target_node, INode insertion_node) {

    }
}
