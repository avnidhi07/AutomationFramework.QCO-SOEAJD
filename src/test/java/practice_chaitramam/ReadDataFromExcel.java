package practice_chaitramam;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
	//Step 1: Open document in java readable format
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
	//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
	//Step 3: Navigate to require sheet
		Sheet sh = wb.getSheet("Organizations");
	//Step 4: Navigate to require row
		Row ro = sh.getRow(7);
	//Step 5: Navigate to require cell
		Cell cel = ro.getCell(1);
	//Step 6: Read the data inside the cell
		DataFormatter getData=new DataFormatter();
		String data = getData.formatCellValue(cel);
	  //String data = cel.getStringCellValue();
		System.out.println(data);
	//Step 7: Close the workbook
		wb.close();

	}

}
