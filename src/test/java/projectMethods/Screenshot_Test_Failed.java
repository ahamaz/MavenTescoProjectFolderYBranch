package projectMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot_Test_Failed {
	WebDriver driver;
	String destinationFile;

	public String getScreenShotPath (String testCaseName, WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
		
	}

}
