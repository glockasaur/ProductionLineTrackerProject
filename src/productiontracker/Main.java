package productiontracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A program where workers can input data about the products that they make into a database.
 *
 * @author Odalys Martinez Villa References: Oracle, Vanselow website, codata.com, stackoverflow
 *     Professor Vanselow, classmates.
 */
public class Main extends Application { // inspection code warning: Entry point.

  /**
   * The starting point of a JavaFx program.
   *
   * @param primaryStage the first thing the user sees
   * @throws Exception for the stage
   */
  @Override
  public void start(Stage primaryStage) throws Exception { // inspection code warning: Entry point.
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    Scene scene = new Scene(root, 600, 425);
    primaryStage.setTitle("Product Tracker");
    primaryStage.setScene(scene);
    scene
        .getStylesheets()
        .add(Main.class.getResource("ProductionLineTracker.css").toExternalForm());
    primaryStage.show();
  }

  /**
   * method for a String.
   *
   * @param args - a String.
   */
  public static void main(String[] args) { // inspection code warning: Entry point.
    launch(args);
  }
}
