package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
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

/**
 * Main entry point for the application.
 * Serves as the VIEW in the MVC
 * @author Eric Kirchgessner.
 */
public class Scrabble extends Application {
  private int width = 1280;
  private int height = 720;
  public static void main(String[] args) {
    launch(args);
  }

  private Pane canvas = new Pane();


  @Override
  public void start(Stage primaryStage) {

    // Making main screen
    primaryStage.setTitle("Calcularbol");

    //Canvas pane
    //Pane canvas = new Pane();
    canvas.setPrefSize(width, height);


    Scene scene = new Scene(canvas, width, height);
    scene.setFill(Color.DARKSLATEBLUE);


    // Draw
    primaryStage.setScene(scene);
    primaryStage.show();


    // manual tests lol
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

    regenerate_tree(width/2, 100, width/2, 100, tree);


  }



  // ---- Node rendering -----

  private final int NODE_PAD_VERTICAL = 64; // Vertical spacing between nodes
  private final int NODE_PAD_HORIZONTAL = 48; // Horizontal spacing between nodes
  private final Color NODE_STROKE_COLOR = Color.CHARTREUSE;
  private final double NODE_STROKE_WEIGHT = 6;

  // switch this to container?
  private void regenerate_tree(int x1, int y1, int x, int y, INode node) {

    var node_render = new Group();


    //Line to node parent
    Line line = new Line(x1, y1, x, y);

    // Circle
    // Node rendering constants
    // Radius of a node
    int NODE_SIZE = 32;
    Circle circle = new Circle(x,y, NODE_SIZE, Color.WHITESMOKE);
    circle.setStrokeType(StrokeType.CENTERED);
    circle.setStroke(NODE_STROKE_COLOR);
    circle.setStrokeWidth(NODE_STROKE_WEIGHT);

    // Label text
    Text txt = new Text(0,0, node.get_label());
    txt.setTextAlignment(TextAlignment.CENTER);
    txt.setBoundsType(TextBoundsType.VISUAL);
    var text_render = new StackPane();
    text_render.setTranslateX(x);
    text_render.setTranslateY(y);
    text_render.getChildren().add(txt);

    //Add elements to container
    node_render.getChildren().addAll(line, circle, text_render);

    // Render different nodes differently depending on type, recursively
    int child_nodes = node.get_children();
    if (child_nodes == 2) {
      regenerate_tree(x, y, x - NODE_PAD_HORIZONTAL, y + NODE_PAD_VERTICAL, node.get_child_a());
      regenerate_tree(x, y, x + NODE_PAD_HORIZONTAL, y + NODE_PAD_VERTICAL, node.get_child_b());
    } else if (child_nodes == 1) {
      regenerate_tree(x, y, x, y + NODE_PAD_VERTICAL, node.get_child_a());
    }


    //Add elements to canvas (in reverse order for proper depth sorting)
    //var group = new Group();
    //group.getChildren().add(node_render);
    //group.setTranslateX(x);
    //group.setTranslateY(y);

    canvas.getChildren().add(node_render);

  }
}