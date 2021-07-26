package controller;

import cl.uchile.dcc.scrabble.gui.ToolBarElement;

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
}
