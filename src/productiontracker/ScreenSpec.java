package productiontracker;

public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();

  void setResolution(String resolution);

  void setRefreshRate(int refreshRate);

  void setResponseTime(int responseTime);
}
