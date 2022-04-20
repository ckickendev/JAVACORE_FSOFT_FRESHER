package JPL.java.exception;

import JPL.java.log4j.LogFile;

public class EmailException extends Exception{
	LogFile log = new LogFile();
	public EmailException() {
		super();// TODO Auto-generated constructor stub
	}
	public EmailException(String mess) {
		super(mess);// TODO Auto-generated constructor stub
		log.printError(mess);
	}
}
