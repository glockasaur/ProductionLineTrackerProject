package productiontracker;

/**
 * MoviePlayer gives information about the type of screen and monitor used in the Product. Class
 * inherits from Product and implements from interface MultimediaControl.
 *
 * @author - Odalys Martinez-Villa
 */
public class MoviePlayer extends Product implements MultimediaControl {
  // screen and monitorType variables
  private Screen screen;
  private MonitorType monitorType;

  /**
   * Constructor for MoviePlayer.
   *
   * @param name - name of product, inherited.
   * @param manufacturer - manufacturer of product, inherited.
   * @param screen - screen of product.
   * @param monitorType - monitor type of product.
   */
  public MoviePlayer(
      String name,
      String manufacturer,
      Screen screen,
      MonitorType monitorType) { // inspection code warning: Constructor is never used.
    super(name, manufacturer, ItemType.Visual);
    this.screen = screen;
    setMonitorType(monitorType);
  }

  /**
   * Method that adds variables to String.
   *
   * @return - a String.
   */
  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
  }

  /** prints out "playing movie" when method called. */
  public void play() {
    System.out.println("Playing movie");
  }

  /** prints out "stopping movie" when method is called. */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /** prints out "previous movie" when method is called. */
  public void previous() {
    System.out.println("Previous movie");
  }

  /** prints out "next movie" when method is called. */
  public void next() {
    System.out.println("Next movie");
  }

  // GETTERS AND SETTERS METHODS
  /**
   * gets Screen type.
   *
   * @return screen.
   */
  public Screen getScreen() { // inspection code warning: Method owner class is never instantiated.
    return screen;
  }

  /**
   * sets screen.
   *
   * @param screen .
   */
  public void setScreen(
      Screen screen) { // inspection code warning: Method owner class is never instantiated.
    this.screen = screen;
  }

  /**
   * gets monitor type.
   *
   * @return monitorType.
   */
  public MonitorType
      getMonitorType() { // inspection code warning: Method owner class is never instantiated.
    return monitorType;
  }

  /**
   * sets monitorType.
   *
   * @param monitorType .
   */
  private void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }
} // end of class.
