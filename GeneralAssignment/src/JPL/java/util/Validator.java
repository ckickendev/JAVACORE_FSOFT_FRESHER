package JPL.java.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;

import JPL.java.exception.InputException;

public class Validator {
	public final Scanner scanner = new Scanner(System.in);
	
	public int checkInputIntLimit(int min, int max) throws InputException{
        while(true){
        	try {
        		int result = Integer.parseInt(scanner.nextLine().trim());
                if(result<min || result>max){
                    System.out.println("Your input wrong, please input again");
                } else {
                   return result;
                }
        	}catch(Exception e) {
        		throw new InputException();
        	}
            
        }
    }
	
	public String checkInputString() throws InputException {
		while (true) {
			String result = scanner.nextLine();
			if (!result.isEmpty()) {
				return result;
			} else {
				throw new InputException();
			}
		}
	}

	public int checkInputTypeInt() throws InputException {
		int intValue = 0;
		do {
			String value = scanner.nextLine();
			try {
				intValue = Integer.parseInt(value);
			} catch (Exception e) {
				throw new InputException();
			}
			break;
		} while (true);
		return intValue;
	}

	public float checkInputTypeFloat() throws InputException {
		float floatValue = 0;
		do {
			String value = scanner.nextLine();
			try {
				floatValue = Float.parseFloat(value);
			} catch (Exception e) {
				throw new InputException();
			}
			break;
		} while (true);
		return floatValue;
	}

	public double inputTypeDouble() throws InputException {
		double doubleValue = 0;
		do {
			String value = scanner.nextLine();
			try {
				doubleValue = Double.parseDouble(value);
			} catch (Exception e) {
				throw new InputException();
			}
			break;
		} while (true);
		return doubleValue;
	}

	public boolean isValidDate(String date) {
		boolean valid = false;
		LocalDate date1;
		try {
			date1 =  LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
			LocalDate date1900 = LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
			LocalDate now = LocalDate.now();
			if(date1.compareTo(date1900)>0 && date1.compareTo(now) < 0) {
				valid = true;				
			}
		} catch (DateTimeParseException e) {
			valid = false;
		}
		return valid;			
	}
	
	public boolean isValidEmailAddress(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
//	public static void main(String[] args) {
//		Validator validator = new Validator();
//		System.out.println(validator.isValidDate("2023-01-02"));
//	}

//    public 
}
