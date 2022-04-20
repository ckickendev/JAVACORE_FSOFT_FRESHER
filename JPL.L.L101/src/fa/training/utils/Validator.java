package fa.training.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 */
public class Validator {

  private static final String VALID_PHONE_REGEX = "^\\d{10,}$";
  private static final String VALID_STUDENT_ID_REGEX = "^\\d{6}$";
  private static final String VALID_COURSE_ID_REGEX = "[A-Z]{2}\\d{3}";
  private static Set<String> ids = new HashSet<String>();

  /**
   * Check phone number format is valid
   * 
   * @param phone
   * @return
   */
  public static boolean isPhone(String phone) {
    Pattern pattern = Pattern.compile(VALID_PHONE_REGEX);
    Matcher matcher = pattern.matcher(phone);
    return matcher.matches();
  }

  /**
   * Check student id format is valid
   * 
   * @param id
   * @return
   */
  public static boolean isStudentId(String id) {
    Pattern pattern = Pattern.compile(VALID_STUDENT_ID_REGEX);
    Matcher matcher = pattern.matcher(id);
    return matcher.matches();
  }

  /**
   * Check if course id format is valid
   * 
   * @param id
   * @return
   */
  public static boolean isCourseId(String id) {
    Pattern pattern = Pattern.compile(VALID_COURSE_ID_REGEX);
    Matcher matcher = pattern.matcher(id);
    return matcher.matches();
  }

  /**
   * Check if credit format is valid
   * 
   * @param credit
   * @return
   */
  public static double isCredit(String credit) {
    double doCredit = 0d;
    try {
      doCredit = Double.parseDouble(credit);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException();
    }
    return doCredit;
  }

  /**
   * Check if enrollment format is valid
   * 
   * @param enrollment
   * @return
   */
  public static int isEnrollment(String enrollment) {
    int intEnrollment = 0;
    try {
      intEnrollment = Integer.parseInt(enrollment);
    } catch (NumberFormatException exception) {
      throw new NumberFormatException();
    }
    return intEnrollment;
  }

  /**
   * Check if an id exists or not
   * 
   * @param id
   * @return
   */
  public static boolean isExisted(String id) {
    if (!ids.contains(id)) {
      ids.add(id);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get the set
   * 
   * @return
   */
  public static Set<String> getIds() {
    return ids;
  }

}
