package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData2 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=0;i<=count;i++) {
			double key = wb.getSheet("Sheet1").getRow(i).getCell(0).getNumericCellValue();
			String value = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			System.out.println(key+" "+value);
		}
		

	}

}
