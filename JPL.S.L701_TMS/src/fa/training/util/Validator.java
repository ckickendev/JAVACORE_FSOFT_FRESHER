package fa.training.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Matcher matcher = null;  
    private static Pattern pattern = null;  
  
 
    public static boolean isDate(String date) {  
        pattern = Pattern.compile(Constant.DATE_PATTERN);  
        matcher = pattern.matcher(date);  
        return matcher.matches();  
    }  
   
    public static boolean isPosition(String position) {  
        pattern = Pattern.compile(Constant.POSITION_PATTERN);  
        matcher = pattern.matcher(position);  
        return matcher.matches();  
    }  

}
