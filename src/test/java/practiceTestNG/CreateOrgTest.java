package practiceTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;

public class CreateOrgTest{

	@Test
	public void createOrg() throws InterruptedException {
		/*JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility wUtil=new WebDriverUtility();*/
		
		WebDriver driver=new ChromeDriver();
		/*driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count = links.size();
		System.out.println(count);
		for(WebElement text:links) {
			System.out.println(text.getAttribute("href"));
		}*/
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(2000);
		List<WebElement> autosugg = driver.findElements(By.xpath("//span[contains(text(),java)]"));
		int count = autosugg.size();
		System.out.println(count);
		for(WebElement text:autosugg) {
			System.out.println(text.getText());
		}
		
		driver.close();
		
		
	}
}
