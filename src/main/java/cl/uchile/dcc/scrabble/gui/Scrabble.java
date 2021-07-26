package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import model.syntax.INode;
import model.syntax.binarynodes.AbstractNodeOperator2;
import model.syntax.binarynodes.operators.NodeMinus;
import model.syntax.binarynodes.operators.NodeOr;
import model.syntax.binarynodes.operators.NodePlus;
import model.syntax.endnodes.NodeBinary;
import model.syntax.endnodes.NodeFloat;
import model.syntax.endnodes.NodeInt;
import model.syntax.unarynodes.operators.NodetoBinary;

import static cl.uchile.dcc.scrabble.gui.ScrabbleColours.*;

/**
 * Main entry point for the application.
 * Serves as the VIEW in the MVC
 * @author Eric Kirchgessner.
 */
public class Scrabble extends Application {
  static Color COLOUR_BACKGROUND = Color.valueOf("#272744");
  static double mouse_anchor_x = 0;
  static double mouse_anchor_y = 0;
  static final double SCALING = 1.1;

  /**
   * Main of the program
   * @param args
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Start the graphical user interface
   * @param primaryStage
   */
  @Override
  public void start(Stage primaryStage) {


    // Making main screen
    primaryStage.setTitle("Calcularbol");
    int height = 1080;
    int width = 1920;

    // Root scene
    var root = new BorderPane();
    root.setPrefSize(width, height);
    Scene scene = new Scene(root, width, height);
    scene.setFill(BACKGROUND);

    // Draw
    primaryStage.setScene(scene);
    primaryStage.show();


    // Manual tree test
    INode tree =	new NodePlus(
            new NodeFloat(
                    6.9
            )
            ,
            new NodeOr(
                    new NodeBinary("1000")
                    ,
                    new NodetoBinary(
                            new NodeMinus(
                                    new NodeInt(25)
                                    ,
                                    new NodeBinary("0101")
                            )
                    )
            )
    );

    // test tree 2
    INode tree2 = new NodePlus(
            new NodePlus(
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))),
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))))
            ),
            new NodePlus(
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))),
                    new NodePlus(new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))), new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1))))
            )
    );

    // Render tree
    var tree_render = TreeNode.build_tree(tree2);
    tree_render.setLayoutX(width/2);
    tree_render.setLayoutY(16);



    /*
     * Zoom event on center pane
     */
    var workspace = new StackPane();
    workspace.getChildren().add(tree_render);
    workspace.addEventHandler(ScrollEvent.SCROLL , e -> {
      double scale_delta = (e.getDeltaY() > 0) ? SCALING : 1/SCALING;
      tree_render.setScaleX(tree_render.getScaleX() * scale_delta);
      tree_render.setScaleY(tree_render.getScaleY() * scale_delta);
    });

    /*
     * Drag event on center pane
     */
    // When pressed set anchor
    //todo: WHY DOES THIS TELEPORT AAAAAAAAAAAAAAAA
    workspace.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
      mouse_anchor_x = e.getX();
      mouse_anchor_y = e.getY();
    });
    // When dragged, move relative to anchor
    workspace.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
      tree_render.setTranslateX(e.getX() - mouse_anchor_x);
      tree_render.setTranslateY(e.getY() - mouse_anchor_y);
    });



    root.setCenter(workspace);


  }

  private static void set_mouse_anchor(double x, double y) {
    mouse_anchor_x = x;
    mouse_anchor_y = y;
  }


}