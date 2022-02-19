package projectMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ahamaz21.SeleniumBrowserTest;

public class BaseAndDataFiles_Calls_Driver_Url extends Base{
	public static Logger log = LogManager.getLogger(SeleniumBrowserTest.class.getName());
	WebDriver driver;
	
	public void basePageNavigationOut() throws IOException, InterruptedException{
	driver = initializeDriver();
	log.debug("Now hitting Tesco Server");
	log.info("Landed on amazon home page");
	driver.get(prop.getProperty("url"));
//	driver.get("https://www.tesco.ie/");
	
	log.info("Window Maximized");
	driver.manage().window().maximize();
	log.info("Waiting for page to upload fully.");
	Thread.sleep(5000);
	}	

}
