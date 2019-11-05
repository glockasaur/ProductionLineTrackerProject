package productiontracker;

/**
 * Adds audio specifications and media types of the Product produced.
 * Inherits from Product.
 * Implements from the interface MultimediaControl.
 * @author - Odalys Martinez-Villa.
 */
public class AudioPlayer extends Product implements MultimediaControl {
  //variables
  private String audioSpecification;
  private String mediaType;

  /**
   * Constructor
   * @param name - name of product, inherited.
   * @param manufacturer - manufacturer of product, inherited.
   * @param type - type of item, inherited.
   * @param audioSpecification - audio specification of product.
   * @param mediaType - media type of product.
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      ItemType type,
      String audioSpecification,
      String mediaType) {
    super(name, manufacturer, type);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * initialize placeholders for audioSpecification and mediaType.
   * @return - prints a String.
   */
  public String toString() {
    String spec = "Supported Audio Formats: " + this.audioSpecification + '\n';
    String media = "Supported Playlist Formats: " + this.mediaType;
    return super.toString() + spec + media;
  }

  /**
   * prints "playing" when called to play.
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * prints "stopping" when called to stop.
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * prints "next" when called to next.
   */
  public void next() {
    System.out.println("Next");
  }

  /**
   * prints "previous" when called to go previous.
   */
  public void previous() {
    System.out.println("Previous");
  }

  //GETTERS AND SETTERS
  /**
   * @return - audioSpecification
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * @param audioSpecification
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * @return - mediaType.
   */
  public String getMediaType() {
    return mediaType;
  }

  /**
   * @param mediaType
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
}
