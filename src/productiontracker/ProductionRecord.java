package productiontracker;

import java.util.Date;

/**
 * Keeps count of the products produced and prints out information about the products that have been
 * produced, including the production number, ID, serial number, and date produced.
 *
 * @author - Odalys Martinez-Villa
 */
class ProductionRecord {
  // variables
  private int productionNumber;
  private int productID;
  private final String serialNumber;
  private final Date dateProduced;

  /**
   * Constructor that sets variables to their values.
   *
   * @param productProduced - Instance of Product.
   * @param itemCount - integer that counts the amount of items.
   */
  public ProductionRecord(
      Product productProduced,
      int itemCount) { // inspection code warning: Constructor is never used.
    // String that formats the number.
    String idNum = String.format("%05d", itemCount);

    // Formats and sets the serialNumber.
    this.serialNumber =
        productProduced.manufacturer.substring(0, 3)
            + productProduced.getType().getValues()
            + idNum;

    // Gives a new date
    this.dateProduced = new Date();
  }

  /**
   * Constructor with one parameter.
   *
   * @param productID - Id of product.
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Constructor that sets the values to the variables.
   *
   * @param productionNumber - production number of product.
   * @param productID - Id of product.
   * @param serialNumber - serial number of product.
   * @param dateProduced - date produced of product.
   */
  public ProductionRecord( // inspection code warning: Constructor is never used.
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Prints out a String that gives information about the Product.
   *
   * @return - a String.
   */
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }
}
