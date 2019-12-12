package productiontracker;

/**
 * This class inherits from Product. Tests out code.
 *
 * @author Odalys Martinez Villa References: Oracle, Vanselow website, codata.com, stackoverflow
 *     Professor Vanselow, classmates.
 */
class Widget extends Product {
  /**
   * Constructor that uses variables from the Product class (inheritance).
   *
   * @param name - name of product.
   * @param manufacturer - manufacturer of product.
   * @param type - type of manufacturer.
   */
  public Widget(String name, String manufacturer, ItemType type) { // inspection code warning: Constructor is never used.
    super(name, manufacturer, type);
  }
}
