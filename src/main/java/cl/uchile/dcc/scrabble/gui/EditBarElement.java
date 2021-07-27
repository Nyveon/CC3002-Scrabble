package cl.uchile.dcc.scrabble.gui;


import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static cl.uchile.dcc.scrabble.gui.ScrabbleColours.*;

/**
 * Button on the node editing VBox
 */
public class EditBarElement {
    private static final String RESOURCE_PATH = "src/main/resources/";

    private static StackPane make_element(String id) {
        var button = new StackPane();

        int image_width = 128;
        int image_height = 128;

        // -Background box-
        double arc = 16;
        var back = new Rectangle((double) image_width /2, (double) image_width /2, image_width, image_width);
        ((Rectangle) back).setArcWidth(arc);
        ((Rectangle) back).setArcHeight(arc);
        back.setFill(LIGHT);
        back.setStrokeType(StrokeType.CENTERED);
        back.setStroke(DARK);
        back.setStrokeWidth(2);

        button.getChildren().add(back);


        // Light up when mouse on top
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            back.setFill(VERYLIGHT);
        });

        // Turn off when mouse not on top
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            back.setFill(LIGHT);
        });


        Tooltip tooltip = new Tooltip("Node type");
        Tooltip.install(button, tooltip);
        tooltip.setShowDelay(Duration.seconds(0.5));
        var text = new Text();
        // Big switch case for button behaviour
        switch (id) {
            case "type end":
                button.getChildren().add(add_sprite(RESOURCE_PATH + "unary.png"));
                tooltip.setText("Leaf node");
                break;
            case "type unary":
                button.getChildren().add(add_sprite(RESOURCE_PATH + "end.png"));
                tooltip.setText("Unary node");
                break;
            case "type binary":
                button.getChildren().add(add_sprite(RESOURCE_PATH + "binary.png"));
                tooltip.setText("Binary node");
                break;
            case "binary":
                text = new Text("Binary number");
                button.getChildren().add(text);
                break;
            case "boolean":
                text = new Text("Boolean value");
                button.getChildren().add(text);
                break;
            case "float":
                text = new Text("Floating point");
                button.getChildren().add(text);
                break;
            case "integer":
                text = new Text("Integer number");
                button.getChildren().add(text);
                break;
            case "string":
                text = new Text("Text string");
                button.getChildren().add(text);
                break;
            case "and":
                text = new Text("Logical and");
                button.getChildren().add(text);
                break;
            case "div":
                text = new Text("Division");
                button.getChildren().add(text);
                break;
            case "minus":
                text = new Text("Subtraction");
                button.getChildren().add(text);
                break;
            case "or":
                text = new Text("Logical or");
                button.getChildren().add(text);
                break;
            case "plus":
                text = new Text("Addition");
                button.getChildren().add(text);
                break;
            case "times":
                text = new Text("Multiplication");
                button.getChildren().add(text);
                break;
            case "not":
                text = new Text("Negation");
                button.getChildren().add(text);
                break;
            case "to binary":
                text = new Text("To Binary");
                button.getChildren().add(text);
                break;
            case "to boolean":
                text = new Text("To Boolean");
                button.getChildren().add(text);
                break;
            case "to float":
                text = new Text("To Float");
                button.getChildren().add(text);
                break;
            case "to integer":
                text = new Text("To Integer");
                button.getChildren().add(text);
                break;
            case "to string":
                text = new Text("To String");
                button.getChildren().add(text);
                break;
        }

        switch (id) {
            case "type end":
            case "type unary":
            case "type binary":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    System.out.println("test");
                    Controller.phase_1 = id;
                    Scrabble.sidebar_2();
                });
                break;
            default:
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    System.out.println("test");
                    Controller.phase_2 = id;
                    Scrabble.sidebar_3();
                });
                break;
        }

        text.setFill(BACKGROUND);
        text.setFont(new Font(18));

        return button;
    }

    /**
     * Initialize phase 1 of the interface
     * @return the side_bar to be rendered (VBox)
     */
    public static VBox phase1() {
        var side_bar = new VBox();

        side_bar.setBackground(new Background(new BackgroundFill(MEDIUM, null, null)));
        side_bar.setSpacing(32);
        side_bar.setPadding(new Insets(32, 16, 32, 16));

        side_bar.getChildren().add(make_element("type end"));
        side_bar.getChildren().add(make_element("type unary"));
        side_bar.getChildren().add(make_element("type binary"));
        return side_bar;
    }


    /**
     * Initialize phase 2 of the interface
     * @return the side_bar to be rendered (VBox)
     */
    public static VBox phase2() {
        var side_bar = new VBox();
        side_bar.setBackground(new Background(new BackgroundFill(MEDIUM, null, null)));
        side_bar.setSpacing(32);
        side_bar.setPadding(new Insets(32, 16, 32, 16));

        switch (Controller.phase_1) {
            case "type end":
                side_bar.getChildren().add(make_element("binary"));
                side_bar.getChildren().add(make_element("boolean"));
                side_bar.getChildren().add(make_element("float"));
                side_bar.getChildren().add(make_element("integer"));
                side_bar.getChildren().add(make_element("string"));
                break;
            case "type unary":
                side_bar.getChildren().add(make_element("not"));
                side_bar.getChildren().add(make_element("to binary"));
                side_bar.getChildren().add(make_element("to boolean"));
                side_bar.getChildren().add(make_element("to float"));
                side_bar.getChildren().add(make_element("to integer"));
                side_bar.getChildren().add(make_element("to string"));
                break;
            case "type binary":
                side_bar.getChildren().add(make_element("and"));
                side_bar.getChildren().add(make_element("div"));
                side_bar.getChildren().add(make_element("minus"));
                side_bar.getChildren().add(make_element("or"));
                side_bar.getChildren().add(make_element("plus"));
                side_bar.getChildren().add(make_element("times"));
                break;
        }

        return side_bar;
    }

    /**
     * Vertical spacer for the edit side-bar
     * @return greedy spacer region
     */
    private Node create_spacer() {
        final Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        return spacer;
    }


    /**
     * Add sprite resource
     * @param file_path path of the resource
     * @throws FileNotFoundException
     */
    private static ImageView add_sprite(String file_path) {
        try {
            var sprite_image = new FileInputStream(file_path);
            var sprite = new ImageView(new Image(sprite_image));
            sprite.setFitWidth(128);
            sprite.setFitWidth(128);
            return sprite;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
