package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=0;i<=count;i++) {
		    String a = wb.getSheet("Sheet1").getRow(i).getCell(0).toString();
			String b = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			System.out.println(a+"-->"+b);
		}
	}
}
