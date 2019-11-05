package productiontracker;

/**
 * Class with variables that are fields for a Screen. This class has gets and setters
 * methods for the variables. toString will return a String when called, which will
 * print the values of each variable of the Screen.
 * Uses the interface ScreenSpec.
 * @author - Odalys Martinez Villa
 */
public class Screen implements ScreenSpec {
  //Variables of Screen
  private String Resolution;
  private int RefreshRate;
  private int ResponseTime;

  /**
   * Constructor that sets values to the variables.
   * @param resolution - screen resolution.
   * @param refreshRate - screen refresh rate.
   * @param responseTime - screen response time.
   */
  Screen(String resolution, int refreshRate, int responseTime) {
    this.Resolution = resolution;
    this.RefreshRate = refreshRate;
    this.ResponseTime = responseTime;
  }

  /**
   * Method that will return a String once called to it.
   * @return - A string.
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + Resolution
        + "\n"
        + "Refresh rate: "
        + RefreshRate
        + "\n"
        + "Response time: "
        + ResponseTime;
  }

  //GETTER AND SETTER METHODS

  /**
   * get the screen's resolution.
   * @return resolution.
   */
  public String getResolution() {
    return Resolution;
  }

  /**
   * set the screen's resolution.
   * @param resolution - screen resolution.
   */
  public void setResolution(String resolution) {
    Resolution = resolution;
  }

  /**
   * get screen's refresh rate.
   * @return - refresh rate.
   */
  public int getRefreshRate() {
    return RefreshRate;
  }

  /**
   * set screen's refresh rate.
   * @param refreshRate
   */
  public void setRefreshRate(int refreshRate) {
    RefreshRate = refreshRate;
  }

  /**
   * get screen's response time.
   * @return response time.
   */
  public int getResponseTime() {
    return ResponseTime;
  }

  /**
   * set screen's response time.
   * @param responseTime
   */
  public void setResponseTime(int responseTime) {
    ResponseTime = responseTime;
  }
} //end of class Screen.
