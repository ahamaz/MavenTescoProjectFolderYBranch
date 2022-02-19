package projectMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelFetchDataMethod {

	
//	public static void main(String[] args) throws IOException {
		// For Method 1 of 3: Change Main Method above line to Method line as:
	public ArrayList<String> getData(String testCaseName) throws IOException { // Get the TestCaseName from other Class and pass to use instead of Purchase hard coded.

		// For Method 2 of 3: Add this line to create an Object to store Data in ArrayList.
		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("ResourcesProject\\DataDrivenExcel.xlsx"); // Workbook location.
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Access the Excel Workbook using above location.

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

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
						System.out.println("TestCases column is present: "+ value);
					}
					k++;
				}
//				System.out.println("TestCases column number is: " + column);

				// 2. Find the Test Case [Purchase] from the column of [Test Cases] identified above, Grab and print now.
				// Make sure right column is selected that has [Purchase, otherwise nothing will print.]

				while(rows.hasNext())
				{
					Row r=rows.next();
//					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase"))
					// Method 0 of 5: Make the testcase dynamic by calling from other class.

					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))

					{
						// Now grab the data of this test case from its row.
						Iterator<Cell>  cv=r.cellIterator();
						while(cv.hasNext())
						{
//							System.out.println(cv.next().getStringCellValue());
							
							// For Method 2 of 3: Add this line to save excel file data into ArrayList to be used by Classes rather than printing above.
//							a.add(cv.next().getStringCellValue());
//							System.out.println("the values saved in array are: " + a); // use to check what is saved in [a] on each iteration.
							
							// To controll the Numeric issue, replace the above [For Method 2 of 3] with following;
							
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue()); // iterating line data is being stored in array [a]. 175
//								System.out.println("the values saved in array are: " + a); // To print what is saved in in Array.
							}
							else
							{
								//a.add(c.getNumericCellValue());
								// add is RED, because array created for STRING but value is numeric, chnage to string.
								a.add(NumberToTextConverter.toText(c.getNumericCellValue())); // Saving data here.
//								System.out.println("the values saved in array are: " + a); // To print what is saved in in Array.
							}
							
						}

					}					
			}
		}
		
	}
		return a; // just under closing } bracket of fist FOR.
	}
}


