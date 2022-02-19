package ahamaz21;

import org.apache.logging.log4j.*;

public class Log4j2Alpha {

	public static class demo {
		public static Logger log= LogManager.getLogger(demo.class.getName());
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		//These logs read configuration file to act upon.
		log.debug("Button is Displayed");
		log.info("Object is present");
		log.error("Button is not Displayed");
		log.fatal("this is fatal");
		}

	}

}
