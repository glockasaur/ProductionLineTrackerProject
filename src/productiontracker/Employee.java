package productiontracker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Will allow a user to input their full name and then create a user id of their first name, a
 * period, and then their surname, an email address of their first initial and last name.
 *
 * @author - Odalys Martinez-Villa.
 */
public class Employee { //code inspection error: can be package private

  // fields: name, username, password, email.
  private final StringBuilder name;
  private String username;
  private final String password;
  private String email;

  /**
   * Constructor that accepts a name and password and will either pass it into the setUsername and
   * setEmail methods or it will give it a default username and email.
   *
   * @param name - name of employee.
   * @param password - password of employee.
   */
  public Employee(String name, String password) {

    this.name = new StringBuilder(name);

    // if name has a space, go to setUsername and setEmail methods.
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else { // if name does not have a space, give it a default username and email.
      username = "default";
      email = "user@oracleacademy.Test";
    }

    // if password has a lowercase, uppercase and special character, set it as the password.
    if (isValidPassword(password)) {
      this.password = password;
    } else { // if not a valid password, set the password to the default: pw.
      this.password = "pw";
    }
  }

  /**
   * sets the username field to the first initial of the first name and then the last name, all
   * lowercase.
   *
   * @param name - name of employee.
   */
  private void setUsername(String name) {

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find(); // inspection code warning: result is ignored.
    String lastName = nameAfterSpaceMatch.group(1);

    String initials = name.substring(0, 1) + lastName;

    this.username = initials.toLowerCase();
  }

  /**
   * checks if the name has a space.
   *
   * @param name - name of employee.
   * @return - found.
   */
  private boolean checkName(String name) {
    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(name);
    return matcher.find();
  }

  /**
   * set the email field to the first name, then a period, then the last name(all lowercase)
   * followed by @orackleacadamy.Test.
   *
   * @param name - name of employee.
   */
  private void setEmail(String name) {

    Pattern nameBeforeSpace = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher nameBeforeSpaceMatch = nameBeforeSpace.matcher(name);
    nameBeforeSpaceMatch.find(); // inspection code warning: result is ignored.
    String firstName = nameBeforeSpaceMatch.group(1);

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find(); // inspection code warning: result is ignored.
    String lastName = nameAfterSpaceMatch.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  /**
   * sets the password field if the password is valid(contains a lowercase, uppercase and spcial
   * character. If invalid, the password field gets set to pw.
   *
   * @param password - password of employee.
   * @return - found.
   */
  private boolean isValidPassword(String password) {

    String regex = "^(?=.[A-Z])+^(?!.[^!a-zA-Z0-9@#$^+=])";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    return matcher.find();
  }

  /**
   * Reverses the password field in order to improve security.
   *
   * @param password - password of employee.
   * @return - password.
   */
  public String reverseString(String password) {
    int length = password.length();
    if (length == 0) {
      return password;
    }
    return reverseString(password.substring(1)) + password.charAt(0);
  }

  /**
   * Converts the fields of the Employee class into a String easily readable to read the employee
   * details.
   *
   * @return - String.
   */
  public String toString() {
    return "Employee Details\n"
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password;
  }
}
