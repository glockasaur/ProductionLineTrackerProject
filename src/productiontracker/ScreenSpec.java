package productiontracker;

/**
 * Interface that sets and gets the variable's values.
 * @author - Odalys Martinez-Villa
 */
public interface ScreenSpec {

  /**
   * get the resolution.
   * @return null.
   */
  String getResolution();

  /**
   * get refresh rate.
   * @return null.
   */
  int getRefreshRate();

  /**
   * get response rate.
   * @return null.
   */
  int getResponseTime();

  /**
   *  set resolution.
   * @param resolution
   */
  void setResolution(String resolution);

  /**
   * set refresh rate.
   * @param refreshRate
   */
  void setRefreshRate(int refreshRate);

  /**
   * set response rate.
   * @param responseTime
   */
  void setResponseTime(int responseTime);
}
