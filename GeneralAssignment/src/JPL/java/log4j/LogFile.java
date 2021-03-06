package JPL.java.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogFile {
	public static Logger logger =  Logger.getLogger(LogFile.class);
	
	public void printInfo(String mess) {
		PropertyConfigurator.configure("resources/log4j1.properties");
        logger.info(mess);
	}
	
	public void printError(String mess) {
		PropertyConfigurator.configure("resources/log4j2.properties");
        logger.error(mess);
	}
	
	public static void main(String[] args) {
		new LogFile().printInfo("hello world");
		new LogFile().printError("Hello world");
	}
}	
