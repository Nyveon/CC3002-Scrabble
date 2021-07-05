package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import syntax.INode;
import syntax.variables.NodeInt;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Eric Kirchgessner.
 */
public class Scrabble extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    // manual tests lol
    INode tree = new NodeInt(1234);
    System.out.println(tree.evaluate());


    primaryStage.setTitle("Scrabble");

    Label label = new Label("This will be an app sometime");
    label.setAlignment(Pos.CENTER);

    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(label, 400, 200);
    primaryStage.setScene(scene);

    primaryStage.show();

  }
}