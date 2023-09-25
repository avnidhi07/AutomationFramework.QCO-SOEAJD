package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteToOnlineExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet2");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		for(int i=0;i<allLink.size();i++) {
			Row r = s.createRow(i);
			Cell c = r.createCell(1);
			c.setCellValue(allLink.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/configfile/Book1.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
