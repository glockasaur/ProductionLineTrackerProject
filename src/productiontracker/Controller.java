package productiontracker;

import java.sql.*; // checkstyle warning
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Used to execute statements, initialize database, add to database and adds
 * values to choice bax and combo box.
 * @author - Odalys Martinez-Villa.
 */
public class Controller { // code inspection error: can be private

    //FXML file
    @FXML public Button AddProductButton; // checkstyle warning
    @FXML public Button RecordProductionNum1; // checkstyle warning
    @FXML private ComboBox ProduceComboBox; // checkstyle warning
    @FXML private ChoiceBox <String> ChooseType;
    @FXML private TableView<Product> prodLineTableView;
    @FXML private TableColumn<?, ?> productNameCol;
    @FXML private TableColumn<?, ?> manufacturerCol;
    @FXML private TableColumn<?, ?> itemTypeCol;
    @FXML private ListView<Product> produceListView;
    @FXML private TextField textName;
    @FXML private TextField textManufacturer;

    // GLOBAL VARIABLE
    private Connection conn;

    private final ObservableList<Product> productLine = FXCollections.observableArrayList();

    /** button clicked to add to the List View */
    @FXML public void handleRecordButtonAction(ActionEvent event){
    }

    /**
     * button clicked to add a name, manufacturer and item type record to database * and display it on
     * the TableView.
     * @param event - the event that the button is clicked.
     * @throws SQLException - uses SQL for the database.
     *
     */
    public void handleAddButtonAction(ActionEvent event) throws SQLException {

        // define an Observable list

        // initialize variables of the textfield: name, manufacturer and item type.
        String productName = textName.getText();
        String productManufacturer = textManufacturer.getText();
        String choice = ChooseType.getValue();

        // The database accepts input from user for name, manufacturer and item type.
        String data = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES(?,?,?)";

        // prepared statement and Connection
        PreparedStatement preparedStm = conn.prepareStatement(data);

        // PreparedStatement will set the values of name, manufacturer and type.
        preparedStm.setString(1, productName);
        preparedStm.setString(2, productManufacturer);
        preparedStm.setString(3, choice);
        preparedStm.executeUpdate();

        // print when button is clicked
        System.out.println("Product Added");

        // clear text fields of name and manufacturer.
        textName.clear();
        textManufacturer.clear();

        // When button is clicked, this will show in the tableView.
        productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        itemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));

        // sets the items to productLine(observableList).
        prodLineTableView.setItems(productLine);

        // Uses Widget to add values of name, manufacturer and item type
        productLine.add(new Widget(productName, productManufacturer, ItemType.valueOf((choice))));

        // sets the values from the product line to the ListView
        produceListView.setItems(productLine);

        // clean up environment
        preparedStm.close();
        conn.close();
    }

    /**
     * initialize the comboBox.
     */
    public void initialize() {
        initializeData();

        //for loop to populate the combo box.
        ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        ProduceComboBox.setItems(list);
        ProduceComboBox.getSelectionModel().selectFirst();
        ProduceComboBox.setEditable(true);

        // enhanced for loop to populate the item choices
        ObservableList<String> itemList = FXCollections.observableArrayList();
        for (ItemType ic : ItemType.values()) {
            System.out.println(ic + " " + ic.values);
            itemList.add(String.valueOf(ic));
        }
        ChooseType.getItems().addAll(itemList);
    }

    private void initializeData() {
        // Connection information
        final String jdbcDriver = "org.h2.Driver"; // checkstyle warning
        final String dbUrl = "jdbc:h2:./res/H2"; // checkstyle warning

        try {
            // Register JDBC driver
            Class.forName(jdbcDriver);

            // Open a connection
            conn = DriverManager.getConnection(dbUrl);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
