package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This is a generic class consisting of all basic configration
 * @author avnish kumar
 *
 */
public class BaseClass {

	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("==========Database Connected Successful==========");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("==========Database Closed Successful==========");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void launchingBrowser() throws Throwable{  //launchingBrowser(String BROWSER) for parallel exe
		System.out.println("======Launching Browser Successfully======");
		
		String BROWSER = pUtil.getLaunchBrowswer("browser");
		String URL = pUtil.getLaunchBrowswer("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("=====Invalid browser Name=====");
		}
		wUtil.maximizeWin(driver);
		wUtil.implicitWait(driver);
		driver.get(URL);
		sdriver=driver;
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("======Closed Browser Successfully======");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Throwable {
	
		String un = pUtil.getLaunchBrowswer("username");
		String pwd = pUtil.getLaunchBrowswer("pass");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginVtiger(un, pwd);
		System.out.println("======Login Successful======");
		}
	@AfterMethod(alwaysRun = true)
	public void logOutVtiger() throws Throwable {
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.moveToSignOut(driver);
		System.out.println("======Logout Successful======");
	}
	
	
	
}