package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewClass {

	public static void main(String[] args) throws IOException {
		
		// write the data on properties file
		Properties p=new Properties();
		p.setProperty("username", "admin");
		p.setProperty("pwd", "manager");
		p.setProperty("url","https://demo.actitime.com/login.do");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/configfile/config.properties");
		p.store(fos, "common data");
		System.out.println("data written successfully");
		
		//fetching the dta from properties file
		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/config.properties");
		p.load(fis);
		String un = p.getProperty("username");
		String pw = p.getProperty("pwd");
		String url=p.getProperty("url");
		System.out.println(un);
		System.out.println(pw);
		System.out.println(url);
		
		//login with the data
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();
		driver.close();

	}

}
