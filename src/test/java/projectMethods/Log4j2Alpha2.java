package projectMethods;

import org.apache.logging.log4j.*;

public class Log4j2Alpha2 {

	public static class demo {
		public static Logger log= LogManager.getLogger(demo.class.getName());
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		//These logs read configuration file to act upon.
		log.debug("I am debugging");
		log.info("Object is present");
		log.error("Object is not present");
		log.fatal("this is fatal");
		}

	}

}
