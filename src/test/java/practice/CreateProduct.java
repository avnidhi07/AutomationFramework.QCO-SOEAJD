package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis=new FileInputStream("src/test/resources/configfile/vtiger.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw=p.getProperty("pass");
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		FileInputStream fi=new FileInputStream("./src/test/resources/configfile/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet s = wb.getSheet("Products");
		Row r = s.getRow(0);
		Cell cel = r.getCell(0);
		String prName = cel.getStringCellValue()+randomNum;
		driver.findElement(By.name("productname")).sendKeys(prName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
