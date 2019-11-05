package productiontracker;

/**
 * Interface that calls getters and setters for Product ID, Name, and Manufacturer.
 * @author - Odalys Martinez-Villa
 */
public interface Item {
  int getProductID();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
