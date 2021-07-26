package cl.uchile.dcc.scrabble.gui;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import model.syntax.INode;

public class TreeNode {
    // Default constants
    private static final int NODE_SIZE = 32;
    private static final int NODE_VERTICAL_SPACING = 78;
    private static final int NODE_HORIZONTAL_SPACING = 48;


    /**
     * Creates a tree of nodes.
     * @param node
     * @return
     */
    public static Group build_tree(INode node) {
        var tree = new Group();
        int max_depth = calculate_depth(node, 0);
        build_branches_recursive(node, tree, 32, 32, 32, 32, max_depth);
        build_node_recursive(node, tree, 0, 0, max_depth);
        return tree;
    }

    /**
     * Auxiliarry function for the spacing of node.s Calculates the deepst point of any type of node tree.
     * Recursive
     * @param node current node being checked.
     * @param depth current depth.
     * @return maximum depth (int)
     */
    private static int calculate_depth(INode node, int depth) {
        depth++;
        int child_nodes = node.get_children();
        if (child_nodes == 2) {
            depth = Math.max(calculate_depth(node.get_child_a(), depth), calculate_depth(node.get_child_b(), depth));
        } else if (child_nodes == 1) {
            depth = calculate_depth(node.get_child_a(), depth);
        }
        return depth;
    }

    /**
     * Build the tree of node's background branches recursively
     * @param node Current node being built
     * @param render_to View it is being rendered to
     * @param x relative x position
     * @param y relative y position
     * @param x1 parent relative x position
     * @param y1 parent relative y position
     * @param height node relative tree height
     */
    public static void build_branches_recursive(INode node, Group render_to, int x, int y, int x1, int y1, int height) {
        height--;

        switch (node.get_children()) {
            case 2:
                build_branches_recursive(node.get_child_a(), render_to, x - NODE_HORIZONTAL_SPACING*height, y + NODE_VERTICAL_SPACING, x, y, height);
                build_branches_recursive(node.get_child_b(), render_to, x + NODE_HORIZONTAL_SPACING*height, y + NODE_VERTICAL_SPACING, x, y, height);
                break;
            case 1:
                build_branches_recursive(node.get_child_a(), render_to, x, y + NODE_VERTICAL_SPACING, x, y, height);
                break;
        }

        // Base case last for depth sorting
        var line = new Line(x1, y1, x, y);
        line.setStroke(Color.valueOf("#c69fa5"));
        line.setStrokeWidth(3);

        render_to.getChildren().add(line);
    }


    /**
     * Build the tree of nodes recursively
     * @param node Current node being built
     * @param render_to View it is being rendered to
     * @param x relative x position
     * @param y relative y position
     * @param height node relative tree height
     */
    private static void build_node_recursive(INode node, Group render_to, int x, int y, int height){
        height--;

        // Different recursive cases
        switch (node.get_children()) {
            case 2:
                build_node_recursive(node.get_child_a(), render_to, x - NODE_HORIZONTAL_SPACING*height, y + NODE_VERTICAL_SPACING, height);
                build_node_recursive(node.get_child_b(), render_to, x + NODE_HORIZONTAL_SPACING*height, y + NODE_VERTICAL_SPACING, height);
                break;
            case 1:
                build_node_recursive(node.get_child_a(), render_to, x, y + NODE_VERTICAL_SPACING, height);
                break;
        }



        // Base case last for depth sorting
        try {
            var this_node = build_node(node);
            this_node.setTranslateX(x);
            this_node.setTranslateY(y);
            render_to.getChildren().add(this_node);
        } catch (IllegalStateException exception) {
            var this_node = new Circle(0, 0, 10, Color.BLACK);
            this_node.setTranslateX(x);
            this_node.setTranslateY(y);
            render_to.getChildren().add(this_node);
        }
    }


    /**
     * Creates a StackPane containing the node circle and node label.
     * @param node Node in question
     * @return Stackpane containing the node circle and node label.
     */
    private static StackPane build_node(INode node) throws IllegalStateException {
        Shape shape = null;
        
        switch (node.get_shape()) {
            case 0:
                shape = new Circle(0, 0, NODE_SIZE);
                break;
            case 1:
                double arc = 16;
                double new_size = NODE_SIZE*2*0.8;
                shape = new Rectangle(new_size/2, new_size/2, new_size, new_size);
                ((Rectangle) shape).setArcWidth(arc);
                ((Rectangle) shape).setArcHeight(arc);
                break;
            default:
                throw new IllegalStateException("Unexpected shape type: " + node.get_shape());
        }
        shape.setStrokeType(StrokeType.CENTERED);
        shape.setFill(Color.valueOf("#494d7e"));
        shape.setStroke(Color.valueOf("#8b6d9c"));
        shape.setStrokeWidth(4);



        // Make node's text
        var value_text = new Text(node.get_label());
        value_text.setTextAlignment(TextAlignment.CENTER);
        value_text.setBoundsType(TextBoundsType.LOGICAL_VERTICAL_CENTER);
        value_text.setFill(Color.valueOf("#f2d3ab"));

        // Output
        var node_stack = new StackPane();
        node_stack.getChildren().addAll(shape, value_text);
        return node_stack;
    }

}