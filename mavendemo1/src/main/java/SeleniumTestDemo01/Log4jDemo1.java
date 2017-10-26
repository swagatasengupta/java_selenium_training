package SeleniumTestDemo01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo1 {
	private static final Logger log = LogManager.getLogger(Log4jDemo1.class.getName());
	public static void main(String[] args) {
			
			log.trace("Trace Message Logged");
			log.debug("Debug Message Logged");
			log.info("Info Message Logged");
			log.error("Error Message Logged");
			log.fatal("Fatal Message Logged");	
		

	}

}
