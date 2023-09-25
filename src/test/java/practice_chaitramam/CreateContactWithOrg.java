package practice_chaitramam;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		String Browser = pUtil.getLaunchBrowswer("browser");
		String url = pUtil.getLaunchBrowswer("url");
        String un = pUtil.getLaunchBrowswer("username");
        String pwd = pUtil.getLaunchBrowswer("pass");
        //polymorphysm ex
        if(Browser.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
        	driver=new ChromeDriver();
        }
        else if(Browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
        	driver=new EdgeDriver();
        }
        else {
        	WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
        }
        wUtil.maximizeWin(driver);
		wUtil.implicitWait(driver);
        driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String orgName = eUtil.getExcelDataUsingDataFormatter("Organizations", 1, 2)+jUtil.getRandomNum();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		String lastName = eUtil.getExcelDataUsingDataFormatter("Contacts", 1, 2)+jUtil.getRandomNum();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		wUtil.handleWindow(driver, "Organizations");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		
		
		
	}

}
