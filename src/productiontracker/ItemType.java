package productiontracker;

/**
 * Enum that gives each item type a 2 letter code.
 * @author Odalys Martinez-Villa.
 */
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String values;

  /**
   * constructor
   * @param value
   */
  ItemType(String value) {
    values = value;
  }

  /**
   * Getter method.
   * @return - values.
   */
  public String getValues() {
    return this.values;
  }
}