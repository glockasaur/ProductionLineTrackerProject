package productiontracker;

/**
 * Interface that sets and gets the variable's values.
 *
 * @author - Odalys Martinez-Villa
 */
interface ScreenSpec {

  /**
   * get the resolution.
   *
   * @return null.
   */
  String getResolution(); // inspection code warning: Method owner class is never instantiated.

  /**
   * get refresh rate.
   *
   * @return null.
   */
  int getRefreshRate(); // inspection code warning: Method owner class is never instantiated.

  /**
   * get response rate.
   *
   * @return null.
   */
  int getResponseTime(); // inspection code warning: Method owner class is never instantiated.

  /**
   * set resolution.
   *
   * @param resolution - resolution.
   */
  void setResolution(
      String resolution); // inspection code warning: Method owner class is never instantiated.

  /**
   * set refresh rate.
   *
   * @param refreshRate - refresh rate.
   */
  void setRefreshRate(
      int refreshRate); // inspection code warning: Method owner class is never instantiated.

  /**
   * set response rate.
   *
   * @param responseTime - response time.
   */
  void setResponseTime(
      int responseTime); // inspection code warning: Method owner class is never instantiated.
}
