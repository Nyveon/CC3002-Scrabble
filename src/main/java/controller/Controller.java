package controller;

import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.gui.ToolBarElement;
import cl.uchile.dcc.scrabble.gui.TreeNode;
import model.Model;
import model.syntax.INode;
import model.syntax.binarynodes.operators.*;
import model.syntax.endnodes.NodeEmpty;
import model.syntax.endnodes.NodeFloat;
import model.syntax.unarynodes.operators.*;

/**
 * Controller class for the MVC
 */
public class Controller {
    public static ToolBarElement currently_selected = null;

    // Editing tool variables
    public static INode selected_node = null;
    public static String phase_1 = null; // Node abstract type
    public static String phase_2 = null; // Node type
    public static String phase_3 = null; // Input variable

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
        selected_node = null;
        signal_view_update();
        Scrabble.close_sidebar();
        //reset presets
        phase_1 = null;
        phase_2 = null;
        phase_3 = null;
    }

    /**
     * Select a node for editing
     * @param node target node
     */
    public static void select_node(INode node) {
        selected_node = node;
        Scrabble.open_sidebar();
    }

    /**
     * Insert a value_less binary node
     */
    public static void insert_no_value() {
        switch (phase_2) {
            case "and":
                insert(new NodeAnd(new NodeEmpty(), new NodeEmpty()));
                break;
            case "div":
                insert(new NodeDiv(new NodeEmpty(), new NodeEmpty()));
                break;
            case "minus":
                insert(new NodeMinus(new NodeEmpty(), new NodeEmpty()));
                break;
            case "or":
                insert(new NodeOr(new NodeEmpty(), new NodeEmpty()));
                break;
            case "plus":
                insert(new NodePlus(new NodeEmpty(), new NodeEmpty()));
                break;
            case "times":
                insert(new NodeTimes(new NodeEmpty(), new NodeEmpty()));
                break;
            case "not":
                insert(new NodeNot(new NodeEmpty()));
                break;
            case "to binary":
                insert(new NodetoBinary(new NodeEmpty()));
                break;
            case "to boolean":
                insert(new NodetoBool(new NodeEmpty()));
                break;
            case "to float":
                insert(new NodetoFloat(new NodeEmpty()));
                break;
            case "to integer":
                insert(new NodetoInt(new NodeEmpty()));
                break;
            case "to string":
                insert(new NodetoString(new NodeEmpty()));
                break;
        }
    }


}
