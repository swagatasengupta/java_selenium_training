package log4jdemo.package2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemoClass2 {

	private static final Logger log = LogManager.getLogger(Log4jDemoClass2.class.getName());

	public static void main(String[] args) {
		log.trace("Trace Message Logged");
		log.info("Info Message Logged");
		log.debug("Debug Message Logged");
		log.warn("Warning Message Logged");
		log.error("Error Message Logged");
		log.fatal("Fatal Message Logged");	
	}
}