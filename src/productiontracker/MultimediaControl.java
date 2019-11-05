package productiontracker;

/**
 * an interface that calls methods.
 *
 * @author - Odalys Martinez-Villa
 */
interface MultimediaControl {
  /** A method to play. */
  void play(); // inspection code warning: Method owner class is never instantiated.

  /** A method to stop. */
  void stop(); // inspection code warning: Method owner class is never instantiated.

  /** A method to go previous. */
  void previous(); // inspection code warning: Method owner class is never instantiated.

  /** A method to go next. */
  void next(); // inspection code warning: Method owner class is never instantiated.
}
