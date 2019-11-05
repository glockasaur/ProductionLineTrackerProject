package productiontracker;

/**
 * Interface that calls getters and setters for Product ID, Name, and Manufacturer.
 *
 * @author - Odalys Martinez-Villa
 */
interface Item {

  /**
   * get product ID.
   *
   * @return null.
   */
  int getProductID(); // inspection code warning: method is never used.

  /**
   * set name.
   *
   * @param name - name.
   */
  void setName(String name); // inspection code warning: Method is never used.

  /**
   * get name.
   *
   * @return null.
   */
  String getName(); // inspection code warning: Method is never used.

  /**
   * set manufacturer.
   *
   * @param manufacturer - manufacturer.
   */
  void setManufacturer(String manufacturer); // inspection code warning: Method is never used.

  /**
   * get manufacturer.
   *
   * @return null.
   */
  String getManufacturer(); // inspection code warning: Method is never used.
}
