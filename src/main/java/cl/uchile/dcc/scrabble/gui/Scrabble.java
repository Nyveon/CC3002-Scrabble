package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    int height = 720;
    int width = 1280;

    // Root scene
    Pane root = new Pane();
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


    var tree_render = TreeNode.build_tree(tree);
    tree_render.setLayoutX(width/2);
    tree_render.setLayoutY(16);
    root.getChildren().add(tree_render);


  }



}