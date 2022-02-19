package ahamaz21;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import projectMethods.Base;


public class AppiumMobileTest extends Base{

	ExtentReports extent;
	
	@BeforeTest
	public void InitializeBrowserAppiumMobile1() throws IOException
	{
		driver = initializeDriver(); 
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void AppiumMobile1() throws IOException
	{
		System.out.println("Appium Test - 1");
	}
	
	@Test
	public void AppiumMobile2() throws IOException
	{
		System.out.println("Appium Test - 2");
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
