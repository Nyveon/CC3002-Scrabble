package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

  public static void main(String[] args) {
    launch(args);
  }

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
                   new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))
                    ,
                    new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))
            ),
            new NodePlus(
                    new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))
                    ,
                    new NodePlus(new NodePlus(new NodeInt(1), new NodeInt(1)), new NodePlus(new NodeInt(1), new NodeInt(1)))
            )
    );

    var tree_render = TreeNode.build_tree(tree);
    tree_render.setLayoutX(width/2);
    tree_render.setLayoutY(16);

    final double SCALE_DELTA = 1.1;
    final StackPane zoomPane = new StackPane();

    // turn this into zoom and translation
    zoomPane.getChildren().add(tree_render);
    zoomPane.setOnScroll(new EventHandler<ScrollEvent>() {
      @Override public void handle(ScrollEvent event) {
        event.consume();

        if (event.getDeltaY() == 0) {
          return;
        }

        double scaleFactor =
                (event.getDeltaY() > 0)
                        ? SCALE_DELTA
                        : 1/SCALE_DELTA;

        tree_render.setScaleX(tree_render.getScaleX() * scaleFactor);
        tree_render.setScaleY(tree_render.getScaleY() * scaleFactor);
      }
    });

    root.setCenter(zoomPane);


  }



}