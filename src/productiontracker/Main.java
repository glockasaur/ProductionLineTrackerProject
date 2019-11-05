package productiontracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A program where workers can input data about the products that they make into a database.
 * @author Odalys Martinez Villa References: Oracle, Vanselow website, codata.com, stackoverflow
 *     Professor Vanselow, classmates.
 */
public class Main extends Application {

    /**
     * The starting point of a JavaFx program.
     * @param primaryStage the first thing the user sees
     * @throws Exception for the stage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 600, 425);
        primaryStage.setTitle("Product Tracker");
        primaryStage.setScene(scene);
        scene
                .getStylesheets()
                .add(Main.class.getResource("ProductionLineTracker.css").toExternalForm());
        primaryStage.show();
    }

    /** @param args a string */
    public static void main(String[] args) {
        launch(args);
    }
}
