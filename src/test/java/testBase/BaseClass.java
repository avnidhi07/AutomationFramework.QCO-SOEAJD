package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties p=new Properties();
	
	@BeforeClass
	public void setUp() throws IOException {
		Reporter.log("open browser successfully",true);
		
		if(driver==null) {
			FileInputStream fis=new FileInputStream("./src/test/resources/configfile/config.properties");
			p.load(fis);
			
		}
		if(p.getProperty("browser").equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.get(p.getProperty("url"));
			
		}
		
		
	}
	

	@AfterClass
	public void tearDown() {
		Reporter.log("close succssefully",true);
		driver.close();
		
	}
	
	
}
