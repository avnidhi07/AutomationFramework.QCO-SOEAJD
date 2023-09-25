package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.CampaignPage;
import POMRepository.CreateCampaignPage;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.ProductsPage;

public class CreateCampaign {

	public static void main(String args[]) throws Throwable {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		
		String br = pUtil.getLaunchBrowswer("browser");
		String url = pUtil.getLaunchBrowswer("url");
		String un = pUtil.getLaunchBrowswer("username");
		String pwd = pUtil.getLaunchBrowswer("pass");
		LoginPage lp=new LoginPage(driver);
		driver.get(url);
		wUtil.maximizeWin(driver);
		wUtil.implicitWait(driver);
		lp.loginVtiger(un, pwd);
		
			
		String prName = eUtil.getExcelDataUsingDataFormatter("Products", 0, 0)+jUtil.getRandomNum();
		String CampName = eUtil.getExcelDataUsingDataFormatter("Campaign", 0, 0)+jUtil.getRandomNum();
		
		//Call from POM class
		HomePage hp=new HomePage(driver);
		hp.clickProductsLnk();
		//Call from POM class
		ProductsPage pp=new ProductsPage(driver);	
		pp.clkOnCreateProductsPage();
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.createNewProduct(prName);
		hp.moveTomore(driver);
		hp.clickCampaign();
		//Call from POM class
		CampaignPage cp=new CampaignPage(driver);
		cp.createCampaign();
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createNewCampaign(CampName, driver, prName);
		hp.moveToSignOut(driver);
		driver.quit();
		}
}
