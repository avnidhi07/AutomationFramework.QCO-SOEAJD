package practice_chaitramam;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.JavaUtility;

public class Demo {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		WebElement search = driver.findElement(By.name("q"));
		Thread.sleep(2000);
		search.sendKeys("i phone 14 pro max");
		search.sendKeys(Keys.ENTER);
		List<WebElement> name = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<String> prName=new ArrayList<>();
		List<String> prPrice=new ArrayList<>();
		for(WebElement iphone:name) {
			prName.add(iphone.getText());
			}
		for(WebElement prices:price) {
			prPrice.add(prices.getText());
		}
		for(int i=0;i<name.size();i++) {
			System.out.println(prName.get(i)+"------------>"+prPrice.get(i));
		}
		JavaUtility j=new JavaUtility();
		String s = j.getSystemDate();
		System.out.println(s);
		driver.close();
		

	}

}
