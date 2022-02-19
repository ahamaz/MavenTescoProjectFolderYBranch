package ahamaz21;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ahamaz21.Log4j2Alpha.demo;
import projectMethods.Base;
import projectMethods.BaseAndDataFiles_Calls_Driver_Url;
import projectMethods.DataDrivenExcelFetchDataMethod;

public class SeleniumBrowserTest extends Base{
	public static Logger log = LogManager.getLogger(SeleniumBrowserTest.class.getName());
	WebDriver driver;

	@Test
	public void SeleniumAutomation1() throws InterruptedException, IOException {

		DataDrivenExcelFetchDataMethod d = new DataDrivenExcelFetchDataMethod();
		ArrayList<String> data = d.getData("Login"); // Getting data only from [Delete Profile] record/row.
		log.info("Printing the URL of landed page.");
		System.out.println("SeleniumBrowserTest - 3");


        // Initializing the Driver.
		// Directly from Driver: 
		log.debug("Setting chrome driver property");
//		System.setProperty("webdriver.chrome.driver", "ResourcesProject\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		// From the Test File using Method below and call it inside:
		basePageNavigationIn(); // Calling from Same Class - Pass
		System.out.println(driver.getCurrentUrl()); //Getting Page Url.
		
//		BaseAndDataFiles_Calls_Driver_Url b = new BaseAndDataFiles_Calls_Driver_Url(); // Calling from other Package - Pass but unable to click a link as below.
//		b.basePageNavigationOut();
//		driver.navigate().forward();
//		System.out.println(driver.getCurrentUrl()); //Getting Page Url.
		
		// Confirm if we are on expected page using Page Title:
		System.out.println(driver.getTitle()); //Getting Page Url.
		Assert.assertEquals("Tesco.ie - online shopping; bringing the supermarket to you.", driver.getTitle());


		log.info("Accepting the Cookies.");
		driver.findElement(By.xpath("//*[@id=\'header\']/div[1]/div/div[2]/form/button/span/span")).click(); // Accept Cookies.
		driver.findElement(By.xpath("//*[@id=\'appbar.my-account\']/span[1]")).click(); // Click Sign-In button.

		driver.navigate().forward();
		
		// Getting Login Data from code:
//				driver.findElement(By.id("txtUserName")).sendKeys("ahasanfsm@hotmail.com"); // Enter UserName
//				driver.findElement(By.id("txtPassword")).sendKeys("EASY2say*"); // Enter Password

		log.info("Entering the Login Credentials.");
		// Getting Login Data from Excel File:
		driver.findElement(By.id("txtUserName")).sendKeys(data.get(1)); // Enter UserName
//				Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys(data.get(2)); // Enter Password
//				Thread.sleep(5000);
		driver.findElement(By.id("btnSubmit")).click();
		System.out.println(driver.getCurrentUrl()); // Getting 2 Page Url to check if the same previous URL.
		//driver.close();
	}

	@Test
	public void SeleniumAutomation2() {

		System.out.println("SeleniumBrowserTest - 4");
		// driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-home[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
		// // Click Join_Now button.
		driver.findElement(By.xpath("//iv[1]/div[1]/div[1]/div[1]/a[1]")).click(); // Click Join_Now button.

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public void basePageNavigationIn() throws IOException, InterruptedException{
	driver = initializeDriver();
	log.debug("Now hitting Tesco Server");
	driver.get(prop.getProperty("url"));
//	driver.get("https://www.tesco.ie/");
	log.info("Landed on amazon home page");
	
	log.info("Window Maximized");
	driver.manage().window().maximize();
	log.info("Waiting for page to upload fully.");
	Thread.sleep(5000);
	}	
}