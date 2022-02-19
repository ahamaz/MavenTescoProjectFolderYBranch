package ahamaz21;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import projectMethods.Base;

public class RestApiTest extends Base{
	@Test
	public void RESTAutomation() throws IOException
	{
		
		System.out.println("RestApiTest -2");
		driver = initializeDriver(); 
		driver.get(prop.getProperty("url"));
		//driver.close();
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
