package logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class App {
	static Logger logger = LogManager.getLogger(App.class);
	public static void main(String[] args) {
		logger.info("Application started!");
		logger.trace("System.out.println( \"Hello World\");");
		System.out.println("Hello World");
		try{
			throw new Exception("Big exception");
		} catch (Exception e) {
			logger.info("Application finished");
		}
		
	}
}
