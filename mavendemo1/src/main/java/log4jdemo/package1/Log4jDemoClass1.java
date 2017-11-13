package log4jdemo.package1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemoClass1 {

	private static final Logger log = LogManager.getLogger(Log4jDemoClass1.class.getName());

	public static void main(String[] args) {
		log.trace("Trace Message Logged");
		log.info("Info Message Logged");
		log.debug("Debug Message Logged");
		log.warn("Warning Message Logged");
		log.error("Error Message Logged");
		log.fatal("Fatal Message Logged");	
	}
}