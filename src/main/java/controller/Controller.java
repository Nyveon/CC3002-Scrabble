package controller;

import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.gui.ToolBarElement;
import cl.uchile.dcc.scrabble.gui.TreeNode;
import model.Model;
import model.syntax.INode;
import model.syntax.endnodes.NodeEmpty;

/**
 * Controller class for the MVC
 */
public class Controller {
    public static ToolBarElement currently_selected = null;

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
        System.out.println("yo");
        Model.tree = new NodeEmpty();
        //Model.tree = Model.tree2;
        signal_view_update();
    }

    /**
     * Method to be called whenever the model is changed by the controller
     */
    private static void signal_view_update() {
        Scrabble.view_update();
    }
}
