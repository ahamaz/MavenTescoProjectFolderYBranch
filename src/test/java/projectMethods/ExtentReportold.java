package projectMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportold {
	
	static ExtentReports extent;
//	ExtentTest test;
//	WebDriver driver;

	@BeforeTest
	public static ExtentReports getReportObject() // Method for Extent Report
	{
	// ExtentReports , ExtentSparkReporter
	String path =System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("EirGrid MPI Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	//ExtentReports extent=new ExtentReports();
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Automation Engineer:", "Ahasan Manzoor Ali");
	return extent;
	}
	
//	@Test
//	public void EirGridTest() // A test must run with [test= extent.createTest("EirGridTest-1")] in start and extent.flush(); at end to inform status to ExtentRepor. 
//	{
//	test= extent.createTest("EirGridTest-1"); // Attach to each test so extent report will know.
//
//	System.setProperty("webdriver.chrome.driver", "ResourcesProject\\drivers\\chromedriver.exe");
//	driver =new ChromeDriver();
//	driver.get("https://rahulshettyacademy.com");
//	System.out.println(driver.getTitle());
////	driver.close();
//	
////	test.addScreenCaptureFromBase64String(s); // To a screenshot
//	test.pass("Result do not match"); // Forcedly Pass/Fail test regarless actual results.
//	extent.flush(); // At the end of last test case to generate report.
//	}
//	
//	@Test
//	public void RESTAutomation()
//	{
//		test= extent.createTest("EirGridTest-2"); // Attach to each test so extent report will know.
//		System.out.println("RESTAPI Test -1");
//		extent.flush(); // At the end of last test case to generate report.
//	}

}
