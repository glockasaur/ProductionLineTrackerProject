package productiontracker;

/**
 * This class inherits from Product.
 * @author Odalys Martinez Villa References: Oracle, Vanselow website, codata.com, stackoverflow
 *     Professor Vanselow, classmates.
 */
class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
  /**
   * public static void main(String[] args){ String userType = ProduceComboBox.value;
   *
   * <p>Widget addedProduct = new Widget(); addedProduct.setType(userType);
   *
   * <p>String sq1 = "INSERT INTO PRODUCT(type, manufacturer, name) VALUES('" +
   * addedProduct.getType() + "', 'Apple', 'iPod' );"; ArrayList<Product> productLine = new
   * ArrayList<>(); productLine.add(addedProduct); }*
   */
}
