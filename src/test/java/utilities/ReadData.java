package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/Book1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> alllink = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<alllink.size();i++) {
			Row r = sh.createRow(i);
			Cell c = r.createCell(1);
			c.setCellValue(alllink.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/configfile/Book1.xlsx");
		wb.write(fos);
		wb.close();
		

	}

}
