package productiontracker;

/**
 * Class with variables that are fields for a Screen. This class has gets and setters methods for
 * the variables. toString will return a String when called, which will print the values of each
 * variable of the Screen. Uses the interface ScreenSpec.
 *
 * @author - Odalys Martinez Villa
 */
public class Screen implements ScreenSpec {
  // Variables of Screen
  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Constructor that sets values to the variables.
   *
   * @param resolution - screen resolution.
   * @param refreshRate - screen refresh rate.
   * @param responseTime - screen response time.
   */
  Screen(
      String resolution,
      int refreshRate,
      int responseTime) { // inspection code warning: Constructor is never used.
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Method that will return a String once called to it.
   *
   * @return - A string.
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshRate
        + "\n"
        + "Response time: "
        + responseTime;
  }

  // GETTER AND SETTER METHODS

  /**
   * get the screen's resolution.
   *
   * @return resolution.
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * set the screen's resolution.
   *
   * @param resolution - screen resolution.
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * get screen's refresh rate.
   *
   * @return - refresh rate.
   */
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * set screen's refresh rate.
   *
   * @param refreshRate - refresh rate.
   */
  public void setRefreshRate(int refreshRate) {
    this.refreshRate = refreshRate;
  }

  /**
   * get screen's response time.
   *
   * @return response time.
   */
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * set screen's response time.
   *
   * @param responseTime - response time.
   */
  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }
} // end of class Screen.
