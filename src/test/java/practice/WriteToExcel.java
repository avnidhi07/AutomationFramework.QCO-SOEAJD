package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet2").createRow(0).createCell(1).setCellValue("guru");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/configfile/Book2.xlsx");
		wb.write(fos);
		wb.close();

	}

}
