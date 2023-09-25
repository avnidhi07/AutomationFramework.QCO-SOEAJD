package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method will read the data from excel file and return the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable {
		//Step 1: Open document in java readable format
		FileInputStream fi=new FileInputStream("./src/test/resources/configfile/Book1.xlsx");
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fi);
		//Step 3: Navigate to require sheet
		Sheet s = wb.getSheet(sheetName);
		//Step 4: Navigate to require row
		Row r = s.getRow(rowNum);
		//Step 5: Navigate to require cell
		Cell cel = r.getCell(cellNum);
		//Step 6: Read the data inside the cell
		String Exceldata = cel.getStringCellValue();
		return Exceldata;
	}
	/**
	 * By Using DataFormatter
	 * This method will read the data from excel file and return the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws Throwable
	 */
	
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable {
		//Step 1: Open document in java readable format
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fi);
		//Step 3: Navigate to require sheet
		Sheet s = wb.getSheet(sheetName);
		//Step 4: Navigate to require row
		Row r = s.getRow(rowNum);
		//Step 5: Navigate to require cell
		Cell cel = r.getCell(cellNum);
		//Step 6: Read the data with Dataformatter
		DataFormatter format=new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		return ExcelData;
	}
	/**
	 * This method will use for read multiple data from excel provided sheetName
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		
	}
}
