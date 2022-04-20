package JPL.java.exception;

import JPL.java.log4j.LogFile;

public class InputException extends Exception {
	LogFile log = new LogFile();
	public InputException() {
		super("The system has encountered an unexpected problem, sincerely sorry !!!\nEnter again!");// TODO Auto-generated constructor stub
		log.printError("The system has encountered an unexpected problem, sincerely sorry !!!");
	}
	public InputException(String mess) {
		super(mess);// TODO Auto-generated constructor stub
		log.printError(mess);
	}
}
