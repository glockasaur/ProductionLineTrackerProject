package productiontracker;

// checkstyle warning

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*; // Checkstyle warning: using * form of import should be avoided.
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Used to execute statements, initialize database, add to database and adds values to choice bax
 * and combo box.
 *
 * @author - Odalys Martinez-Villa.
 */
public class Controller { // code inspection error: can be private.

  // FXML file
  @FXML public Button AddProductButton; // checkstyle warning. Inspection code warning.

  @FXML
  public Button RecordProductionNum1; // checkstyle warning. inspection code warning: Entry point.

  @FXML
  private ComboBox ProduceComboBox; // checkstyle warning. inspection code warning: Entry point.

  @FXML
  private ChoiceBox<String> ChooseType; // checkstyle warning. Inspection code warning entry point.

  @FXML private TableView<Product> prodLineTableView; // inspection code warning: Entry point.
  @FXML private TableColumn<?, ?> productNameCol; // inspection code warning: Entry point.
  @FXML private TableColumn<?, ?> manufacturerCol; // inspection code warning: Entry point.
  @FXML private TableColumn<?, ?> itemTypeCol; // inspection code warning: Entry point.
  @FXML private ListView<Product> produceListView; // inspection code warning: Entry point.
  @FXML private TextField textName; // inspection code warning: Entry point.
  @FXML private TextField textManufacturer; // inspection code warning: Entry point.
  @FXML private TextArea ProdTextArea; // checkstyle warning. inspection code warning: entry point.
  @FXML private TextArea EmployeeTextArea;
  @FXML private TextField loginUsername;
  @FXML private TextField loginPassword;
  @FXML private Button loginButton;

  // GLOBAL VARIABLES
  private Statement stmt;
  private Connection conn;

  // observable list used for the table view.
  private final ObservableList<Product> productLine = FXCollections.observableArrayList();

  // observable list used for a production record.
  final ObservableList<ProductionRecord> productionRun = FXCollections.observableArrayList();

  /**
   * button clicked to add to the List View. When the button is clicked, it will get the amount of
   * products selected to be added to the database by using an ArrayList. *
   *
   * @throws SQLException - uses SQL for the database.
   */
  public void handleRecordButtonAction() throws SQLException {
    // get selected product from the list view.
    Product record = produceListView.getSelectionModel().getSelectedItem();

    // get the quantity of the product from the combobox.
    int quantityAmt;
    quantityAmt =
        Integer.parseInt(String.valueOf(ProduceComboBox.getSelectionModel().getSelectedItem()));

    // ProductionRecord object
    ProductionRecord pr;

    // create an ArrayList of ProductionRecord objects named productionRun
    for (int i = 0; i < quantityAmt; i++) {
      pr = new ProductionRecord(record, i);
      productionRun.add(pr);
    }

    // call addToProductionDB
    addToProductionDB(productionRun);

    // call showProduction
    showProduction(productionRun);

    // call loadProductionLog
    loadProductionLog(productionRun);
  }
  // inspection code warning: Entry point.

  /**
   * button clicked to add a name, manufacturer and item type record to database * and display it on
   * the TableView.
   *
   * @throws SQLException - uses SQL for the database.
   */
  public void handleAddButtonAction() throws SQLException { // inspection code warning: entry point.
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

    // Uses Widget to add values of name, manufacturer and item type
    // productLine.add(new Widget(productName, productManufacturer, ItemType.valueOf(choice)));

    // Call setupProductLineTable
    setupProductLineTable(productLine);

    // Call loadProductList
    loadProductList(productLine);
  }

    /**
     *
     */
  public void handleLoginButtonAction() {
    employeeDetail();
  }

  /**
   * Set the items of the TableView to the ObservableList.
   *
   * @param productLine - observableList.
   */
  private void setupProductLineTable(ObservableList<Product> productLine) {
    // When button is clicked, this will show in the tableView.
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    itemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));

    // sets the items to productLine(observableList).
    prodLineTableView.setItems(this.productLine);

    // sets the values from the product line to the ListView
    produceListView.setItems(this.productLine);
  }

  private void loadProductList(ObservableList<Product> productLine) throws SQLException {
    String loadsql = "SELECT * FROM PRODUCT";

    Statement statement = conn.createStatement();
    ResultSet rs = statement.executeQuery(loadsql);
    while (rs.next()) {
      // these lines correspond to the database table columns
      String name = rs.getString(2);
      String manufacturer = rs.getString(3);
      String type = rs.getString(4);
      Product prodDB = new Product(name, manufacturer, ItemType.valueOf((type))) {};
      // save to observable list.
      productLine.add(prodDB);
    }
  }

  /**
   * Populates the TextArea in the Production Log Tab with the information from the productionLog.
   *
   * @param productionRun - observableList.
   */
  private void showProduction(ObservableList<ProductionRecord> productionRun) {
    // sets the text in the TextArea with the fields from the database.
    ProdTextArea.setText(productionRun.toString());
  }

  /**
   * Loops through the productionRun, inserting productionRecord object information into the
   * ProductionRecord database table.
   *
   * @param productionRun - observableList.
   * @throws SQLException - an exception.
   */
  private void addToProductionDB(ObservableList<ProductionRecord> productionRun)
      throws SQLException {
    // for loop to i
    for (ProductionRecord pr : productionRun) {
      int prodID = pr.getProductID();
      String serialNumber = pr.getSerialNumber();
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());

      // insert into the database.
      String sql =
          "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)VALUES (?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);

      //
      pstmt.setInt(1, prodID);
      pstmt.setString(2, serialNumber);
      pstmt.setTimestamp(3, timestamp);

      // execute update the prepared statement.
      pstmt.executeUpdate();

      //
      showProduction(productionRun);
    }
  }

  private void loadProductionLog(ObservableList<ProductionRecord> productionRun)
      throws SQLException {
    //
    String sql = "SELECT * FROM PRODUCTIONRECORD";
    stmt = conn.createStatement();

    //
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      int num = rs.getInt("Production_Num");
      int id = rs.getInt("Product_ID");
      String serial = rs.getString("Serial_Num");
      Date date = rs.getDate("Date_Produced");

      //
      ProductionRecord DBRecord = new ProductionRecord(num, id, serial, date) {};

      //
      System.out.println(DBRecord.toString());

      //
      productionRun.add(DBRecord);

      //
      showProduction(productionRun);
    }
  }

  public void employeeDetail() {
    String name = loginUsername.getText();

    String password = loginPassword.getText();

    Employee employee = new Employee(name, password);
    System.out.println(employee.reverseString(password));
    System.out.println(employee);

    EmployeeTextArea.setText(String.valueOf(employee));
  }

  /** populate the combobox, choice box. Display a string into the TextArea. */
  public void initialize() { // inspection code warning: entry point.
    // call to initialize the database connection.
    initializeData();

    // use Observable list to populate the combo box.
    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ProduceComboBox.setItems(
        list); // inspection code warning: unchecked call to 'setItems(ObservableList)' as a member
    // of raw type 'javafx.scene.control.ComboBox.
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

    // enhanced for loop to populate the item choices
    ObservableList<String> itemList = FXCollections.observableArrayList();
    for (ItemType typeItem : ItemType.values()) {
      System.out.println(typeItem + " " + typeItem.values);
      itemList.add(String.valueOf(typeItem));
    }
    ChooseType.getItems().addAll(itemList);

    // Display an instance of ProductionRecord in the Text Area in the Production Log tab
    ProductionRecord prodRec = new ProductionRecord(0);
    String prod = prodRec.toString();
    ProdTextArea.setText(prod);
  }

  /** Initializes the database by registering the JDBC driver and opening a connection. */
  private void initializeData() {
    // Connection information
    final String jdbcDriver = "org.h2.Driver"; // checkstyle warning
    final String dbUrl = "jdbc:h2:./res/H2"; // checkstyle warning
    System.out.println("Attempting to connect to the database...");
    try {
      // Register JDBC driver
      Class.forName(jdbcDriver);

      // Open a connection
      conn = DriverManager.getConnection(dbUrl);

      System.out.println("Successfully connected to the database!");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
