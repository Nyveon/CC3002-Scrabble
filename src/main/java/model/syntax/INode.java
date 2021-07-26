package model.syntax;

import model.types.IScrabbleVariable;

/**
 * Node object interface
 * Composite design pattern
 */
public interface INode {
    // All nodes must be able to be evaluated into a scrabble variable
    // How each node evaluates may vary.
    public IScrabbleVariable evaluate();
    public int get_children();

    // Method for getting the first child of a node. Defaults to null.
    default INode get_child_a() {
        return null;
    }

    // Method for getting the second child of a node. Defaults to null.
    default INode get_child_b() {
        return null;
    }

    // Method for getting the shape a node should render as
    default int get_shape() {
        return 0;
    }

    public String get_label();
}
