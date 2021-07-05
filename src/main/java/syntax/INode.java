package syntax;

import types.AbstractScrabbleVariable;
import types.IScrabbleVariable;

/**
 * Node object interface
 * Composite design pattern
 */
public interface INode {
    // All nodes must be able to be evaluated into a scrabble variable
    // How each node evaluates may vary.
    public IScrabbleVariable evaluate();

}
