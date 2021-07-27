package cl.uchile.dcc.scrabble.gui;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import model.Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static cl.uchile.dcc.scrabble.gui.ScrabbleColours.*;

/**
 * Button on the toolbar HBox.
 * Semi-factory design pattern (Yes, I made that up xd)
 */
public class ToolBarElement {
    private static final String RESOURCE_PATH = "src/main/resources/";
    public StackPane button = new StackPane();
    public ImageView sprite;
    private final int image_height;
    private final int image_width;
    private final Rectangle front;
    public int selected_type = 0;

    public ToolBarElement(String button_type, int image_width, int image_height) {
        this.image_width = image_width;
        this.image_height = image_height;

        // -Background box-
        double arc = 16;
        var back = new Rectangle((double) image_width /2, (double) image_width /2, image_width, image_width);
        ((Rectangle) back).setArcWidth(arc);
        ((Rectangle) back).setArcHeight(arc);
        back.setFill(LIGHT);
        back.setStrokeType(StrokeType.CENTERED);
        back.setStroke(DARK);
        back.setStrokeWidth(2);

        // -Foreground box-
        front = new Rectangle((double) image_width /2, (double) image_width /2, image_width, image_width);
        ((Rectangle) front).setArcWidth(arc);
        ((Rectangle) front).setArcHeight(arc);
        front.setFill(BACKGROUND);
        front.opacityProperty().set(0);


        Tooltip tooltip = new Tooltip("default tooltip");
        Tooltip.install(button, tooltip);
        tooltip.setShowDelay(Duration.seconds(0.5));
        // --Initialize the different button types--
        try {
            switch (button_type) {
                case "help":
                    add_sprite(RESOURCE_PATH + "help.png");
                    tooltip.setText("Get Help.");
                    break;
                case "zoom in":
                    add_sprite(RESOURCE_PATH + "zoom_in.png");
                    tooltip.setText("Zoom In.");
                    break;
                case "zoom out":
                    add_sprite(RESOURCE_PATH + "zoom_out.png");
                    tooltip.setText("Zoom Out.");
                    break;
                case "center":
                    add_sprite(RESOURCE_PATH + "center.png");
                    tooltip.setText("Reset View.");
                    break;
                case "play":
                    add_sprite(RESOURCE_PATH + "play.png");
                    selected_type = 1;
                    tooltip.setText("Calculate specific node.");
                    break;
                case "play all":
                    add_sprite(RESOURCE_PATH + "play_all.png");
                    tooltip.setText("Calculate all nodes.");
                    break;
                case "trash":
                    add_sprite(RESOURCE_PATH + "trash.png");
                    selected_type = 2;
                    tooltip.setText("Delete specific node.");
                    break;
                case "trash all":
                    add_sprite(RESOURCE_PATH + "trash_all.png");
                    tooltip.setText("Delete all nodes.");
                    break;
                case "edit":
                    add_sprite(RESOURCE_PATH + "edit.png");
                    Controller.set_selected(this);
                    selected_type = 0;
                    tooltip.setText("Edit nodes.");
                    break;
                default:
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        // --Shared button events--
        switch (button_type) {

            // Selector buttons
            case "edit":
            case "trash":
            case "play":
                // Flip selected property
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Controller.set_selected(this);
                });
                break;

            // Play all
            case "play all":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Scrabble.set_result(Model.tree.evaluate());
                });
                break;

            // Zoom in and out (or reset)
            case "zoom in":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Scrabble.zoom(1d);
                });
                break;
            case "zoom out":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Scrabble.zoom(-1d);
                });
                break;
            case "center":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Scrabble.reset_view();
                });
                break;

            // Open help
            case "help":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    OpenBrowser.open("https://github.com/CC3002-Metodologias/scrabble-Nyveon/blob/main/README.md");
                });
                break;

            // Trash all
            case "trash all":
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                    Controller.reset();
                });
                break;
        }

        // Light up when mouse on top
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            back.setFill(VERYLIGHT);
        });

        // Turn off when mouse not on top
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            back.setFill(LIGHT);
        });


        //Add elements to the thing
        button.getChildren().add(back);
        button.getChildren().add(sprite);
        button.getChildren().add(front);
    }


    /**
     * Add sprite resource
     * @param file_path path of the resource
     * @throws FileNotFoundException
     */
    private void add_sprite(String file_path) throws FileNotFoundException {
        var sprite_image = new FileInputStream(file_path);
        sprite = new ImageView(new Image(sprite_image));
        sprite.setFitWidth(image_width);
        sprite.setFitWidth(image_height);
    }

    /**
     * When a selectable node is elected, modify visuals
     */
    public void select() {
        button.setScaleX(0.9);
        button.setScaleY(0.9);
        front.opacityProperty().set(0.5);
    }

    /**
     * Reset visuals
     */
    public void deselect() {
        button.setScaleX(1);
        button.setScaleY(1);
        front.opacityProperty().set(0);
    }

}
