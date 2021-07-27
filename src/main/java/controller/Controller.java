package controller;

import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.gui.ToolBarElement;
import cl.uchile.dcc.scrabble.gui.TreeNode;
import model.Model;
import model.syntax.INode;
import model.syntax.endnodes.NodeEmpty;
import model.syntax.endnodes.NodeFloat;

/**
 * Controller class for the MVC
 */
public class Controller {
    public static ToolBarElement currently_selected = null;
    public static INode selected_node = null;

    /**
     * Double dispatch for setting the currently selected mouse-cursor node-modification tool
     * @param new_selected the new id being selected
     */
    public static void set_selected(ToolBarElement new_selected) {
        if (currently_selected == null) { // Base case
            currently_selected = new_selected;
            new_selected.select();
        } else if (new_selected != currently_selected) {
            new_selected.select();
            currently_selected.deselect();
            currently_selected = new_selected;
        }
    }

    /**
     * Method for returning an index of the current selected button
     * 0 - Edit tool
     * 1 - Run tool
     * 2 - Trash tool
     * @return int of index
     */
    public static int get_selected() {
        return currently_selected.selected_type;
    }

    /**
     * Method for resetting the model
     */
    public static void reset() {
        Model.tree = new NodeEmpty();
        //Model.tree = Model.tree4;
        signal_view_update();
    }

    /**
     * Method to be called whenever the model is changed by the controller
     */
    private static void signal_view_update() {
        Scrabble.view_update();
    }

    /**
     * Insertion deletion of a specific node within the model
     * @param node Target for deletion
     */
    public static void delete(INode node) {
        if (Model.tree == node) { // Base case
            reset();
        } else { // Recursive deletion by the model
            Model.tree.delete(node);
            signal_view_update();
        }
    }

    /**
     * Insertion of a specific node within the model.
     * Target is the currently selected node.
     * @param node Node to be inserted.
     */
    public static void insert(INode node) {
        if (selected_node != null) {
            if (Model.tree == selected_node) {
                Model.tree = node;
            } else {
                Model.tree.insert(selected_node, node);
            }
        }
        signal_view_update();
    }
}
