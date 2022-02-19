package ahamaz21;


import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import projectMethods.DataDrivenExcelFetchDataMethod;

public class DataDrivenExcelPrintDataMethod {
	//@Test 
//	public static void main(String[] args) throws IOException {
	public void ExcelData() throws IOException {	
		// TODO Auto-generated method stub
		DataDrivenExcelFetchDataMethod d=new DataDrivenExcelFetchDataMethod();
		ArrayList<String> data=d.getData("Login"); // Getting data only from [Delete Profile] record/row.
		
		System.out.println("Test Case Name  : " + data.get(0));
		System.out.println("Test Case Data-1: " +data.get(1));
		System.out.println("Test Case Data-2: " +data.get(2));
		System.out.println("Test Case Data-3: " +data.get(3));
//		// Now use the data in website
//		//driver.findElement(by.xpath("xpath")).sendKeys(data.get(1));
	}
}
