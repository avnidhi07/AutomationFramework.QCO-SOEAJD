package practice_chaitramam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='Sat Aug 12 2023']")).click();
		driver.findElement(By.xpath("//div[.='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='4']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		WebElement element = driver.findElement(By.xpath("(//span[@class='sc-12foipm-64 hkDsNh'])[2]"));
		WebElement ele = driver.findElement(By.xpath("(//span[@class='sc-12foipm-64 hkDsNh'])[4]"));
		WebElement el = driver.findElement(By.xpath("(//span[@class='sc-12foipm-64 hkDsNh'])[6]"));
		for(int i=0;i<5;i++) {
			element.click();
			//ele.click();
			//el.click();
		}
		for(int i=0;i<2;i++) {
			ele.click();
		}

	}

}
