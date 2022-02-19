package projectMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelFetchDataClass {

	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("Resources\\DataDrivenExcel.xlsx"); // Workbook location.
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Access the Excel Workbook using above location.

		// Store Data in Array;
		

		// Access to desired [testdata] sheet inside Workbook and save its Data.
		int sheets = workbook.getNumberOfSheets(); // Check number of sheets in Workbook.
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				// Sheet has been found.
				XSSFSheet sheet = workbook.getSheetAt(i);
				System.out.println(sheet);

				// 1. Find the [Test Cases] cell by scanning the entire first row.
				Iterator<Row> rows = sheet.iterator(); // Sheet is collection of rows.
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator(); // Row is collection of cells.

				int k = 0; // Use to get the required column number of required column [TestCases].
				int column = 0;

				while (cell.hasNext()) {
					Cell value = cell.next();

					if (value.getStringCellValue().equalsIgnoreCase("Test Cases")) {
						column = k;
						System.out.println("TestCases column is present: "+ value);
					}
					k++;
				}
				System.out.println("TestCases column number is:" + column);

				// 2. Find the Test Case [Purchase] from the column of [Test Cases] identified above, Grab and print now.
				// Make sure right column is selected that has [Purchase, otherwise nothing will print.]
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase"))
					{
						// Now grab the data of this test case from its row.
						Iterator<Cell>  cv=r.cellIterator();
						while(cv.hasNext())
						{
							System.out.println(cv.next().getStringCellValue());
						}
					}


				// 3. Connect and send this data garbed in step-2 to a test case to use rather than print here only.
				// Need Array to store the data in proper way and use it in test case.
					
					
					

			}
		}
		}
	}
}
