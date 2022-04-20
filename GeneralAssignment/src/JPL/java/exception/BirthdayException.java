package JPL.java.exception;

import JPL.java.log4j.LogFile;

public class BirthdayException extends Exception{
	LogFile log = new LogFile();
	
	public BirthdayException(String mess) {
		super(mess);
		log.printError(mess);
	}
	
	public BirthdayException() {
		super();
	}

}
