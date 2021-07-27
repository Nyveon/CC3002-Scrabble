package cl.uchile.dcc.scrabble.gui;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import model.Model;
import model.syntax.INode;
import model.syntax.binarynodes.AbstractNodeOperator2;
import model.syntax.binarynodes.operators.NodeMinus;
import model.syntax.binarynodes.operators.NodeOr;
import model.syntax.binarynodes.operators.NodePlus;
import model.syntax.binarynodes.operators.NodeTimes;
import model.syntax.endnodes.NodeBinary;
import model.syntax.endnodes.NodeEmpty;
import model.syntax.endnodes.NodeFloat;
import model.syntax.endnodes.NodeInt;
import model.syntax.unarynodes.operators.NodetoBinary;
import model.syntax.unarynodes.operators.NodetoInt;
import model.types.IScrabbleVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static cl.uchile.dcc.scrabble.gui.ScrabbleColours.*;

/**
 * Main entry point for the application.
 * Serves as the VIEW in the MVC
 * @author Eric Kirchgessner.
 */
public class Scrabble extends Application {
  private static final String RESOURCE_PATH = "src/main/resources/";
  private static double mouse_anchor_x = 0;
  private static double mouse_anchor_y = 0;
  private static final double SCALING = 1.1;
  static final StackPane workspace = new StackPane();
  public static Group tree_render = new Group();
  private final static Text latest_result = new Text("Latest Result: None");
  private final static BorderPane root = new BorderPane();
  private static VBox side_bar = new VBox();

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
    try {
      primaryStage.getIcons().add(new Image(new FileInputStream(RESOURCE_PATH + "icon.png")));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int height = 1080;
    int width = 1920;

    // Root scene
    root.setPrefSize(width, height);
    Scene scene = new Scene(root, width, height);
    root.setBackground(new Background(new BackgroundFill(BACKGROUND, null, null)));


    // Draw
    primaryStage.setScene(scene);
    primaryStage.show();

    /*
     * Workspace
     */
    // Render tree
    tree_render = TreeNode.build_tree(Model.tree);
    tree_render.setLayoutX(width/2);
    tree_render.setLayoutY(16);


    //Zoom event on center pane
    workspace.getChildren().add(tree_render);
    workspace.addEventHandler(ScrollEvent.SCROLL , e -> {
      zoom(e.getDeltaY());
    });


    // -Drag event on center pane-
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


    /*
     * Toolbar
     */
    var top_bar = new BorderPane();
    top_bar.setBackground(new Background(new BackgroundFill(MEDIUM, null, null)));

    final int ICON_SIZE = 72;
    final int ICON_PAD = 18;

    var toolbar = new HBox();
    toolbar.setSpacing(ICON_PAD);
    toolbar.setPadding(new Insets(8d, 16d, 8d, 16d));
    //toolbar.setBackground(new Background(new BackgroundFill(MEDIUM, null, null)));



    toolbar.getChildren().add(new ToolBarElement("help", ICON_SIZE, ICON_SIZE).button);

    toolbar.getChildren().add(make_bar());

    // View tools
    toolbar.getChildren().add(new ToolBarElement("zoom in", ICON_SIZE, ICON_SIZE).button);
    toolbar.getChildren().add(new ToolBarElement("zoom out", ICON_SIZE, ICON_SIZE).button);
    toolbar.getChildren().add(new ToolBarElement("center", ICON_SIZE, ICON_SIZE).button);

    toolbar.getChildren().add(make_bar());

    // Hand tools
    toolbar.getChildren().add(new ToolBarElement("play", ICON_SIZE, ICON_SIZE).button);
    toolbar.getChildren().add(new ToolBarElement("trash", ICON_SIZE, ICON_SIZE).button);
    toolbar.getChildren().add(new ToolBarElement("edit", ICON_SIZE, ICON_SIZE).button);

    toolbar.getChildren().add(make_bar());

    // Batch tools

    toolbar.getChildren().add(new ToolBarElement("play all", ICON_SIZE, ICON_SIZE).button);
    toolbar.getChildren().add(new ToolBarElement("trash all", ICON_SIZE, ICON_SIZE).button);


    var result = new HBox();
    result.setSpacing(18);
    result.setPadding(new Insets(8d, 16d, 8d, 16d));
    result.setBackground(new Background(new BackgroundFill(MEDIUM, null, null)));


    // Latest result text
    latest_result.setFill(BACKGROUND);
    latest_result.setStroke(BACKGROUND.darker());
    latest_result.setStrokeWidth(1);
    latest_result.setFont(new Font(36));
    result.getChildren().add(latest_result);

    top_bar.setLeft(toolbar);
    top_bar.setRight(result);
    root.setTop(top_bar);


    /*
    var test_rect = new Rectangle(0, 0, 128, 128);

    test_rect.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
      Controller.insert(new NodeFloat(6.9));
    });


    side_bar.getChildren().add(test_rect);
    side_bar.getChildren().add(create_spacer());
    side_bar.getChildren().add(new Rectangle(0, 0, 128, 128));
    side_bar.getChildren().add(create_spacer());
    side_bar.getChildren().add(new Rectangle(0, 0, 128, 128));
    side_bar.getChildren().add(create_spacer());
    side_bar.getChildren().add(new Rectangle(0, 0, 128, 128));
    side_bar.getChildren().add(create_spacer());
    side_bar.getChildren().add(new Rectangle(0, 0, 128, 128));
    root.setRight(side_bar);
    */



  }

  /**
   * Open the node-edit sidebar
   */
  public static void open_sidebar() {
    side_bar = EditBarElement.phase1();
    root.setRight(side_bar);
  }

  /**
   * Activate the SECOND PHASE
   */
  public static void sidebar_2() {
    side_bar = EditBarElement.phase2();
    root.setRight(side_bar);
  }

  /**
   * Activate the final phase and prompt for user input text
   */
  public static void sidebar_3() {
    close_sidebar();

    if (Controller.phase_1.equals("type binary") || Controller.phase_1.equals("type unary")) {
      Controller.insert_no_value();
    } else {
      TextInputDialog td = new TextInputDialog();
      td.setContentText("Node Input");
      td.setHeaderText("Input the value you wish this node to have");
      td.showAndWait();

      Controller.insert_value(td.getEditor().getText());
    }

  }

  /**
   * Open the node-edit sidebar
   */
  public static void close_sidebar() {
    root.setRight(null);
  }

  /**
   * Make a horizontal separator bar for the toolbar element
   * @return Toolbar object if possible
   */
  private static ImageView make_bar() {
    try{
      var bar_image = new FileInputStream(RESOURCE_PATH + "bar.png");
      return new ImageView(new Image(bar_image));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Zoom the workspace view
   * @param direction zoom in > 0 > zoom out
   */
  public static void zoom(double direction) {
    double scale_delta = (direction > 0) ? SCALING : 1/SCALING;
    tree_render.setScaleX(tree_render.getScaleX() * scale_delta);
    tree_render.setScaleY(tree_render.getScaleY() * scale_delta);
  }

  /**
   * Reset workspace view to default values
   */
  public static void reset_view() {
    tree_render.setScaleX(1);
    tree_render.setScaleY(1);
    tree_render.setTranslateX(0);
    tree_render.setTranslateY(0);
  }

  /**
   * Set the result variable externally
   * @param evaluate the ScrabbleVariable from the evaluation
   */
  public static void set_result(IScrabbleVariable evaluate) {
    latest_result.setText("Latest result: " + evaluate.toString());
  }

  /**
   * Update the tree view
   * Called by the controller when a change is made
   */
  public static void view_update() {
    latest_result.setText("Latest Result: None");
    workspace.getChildren().remove(tree_render);
    tree_render = TreeNode.build_tree(Model.tree);
    workspace.getChildren().add(tree_render);
    System.out.println("yo2");
  }
}