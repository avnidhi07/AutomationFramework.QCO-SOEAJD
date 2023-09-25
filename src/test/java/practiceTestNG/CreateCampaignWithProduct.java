package practiceTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.CampaignPage;
import POMRepository.CreateCampaignPage;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.ProductsPage;

//@Listeners(Generic_Utilities.ListenerImplimentation.class)
public class CreateCampaignWithProduct extends BaseClass {

	@Test
	public void createCampaign() throws Throwable {
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
	    	
		//Call from POM class
		HomePage hp=new HomePage(driver);
		
		hp.clickProductsLnk();
		//Call from POM class
		ProductsPage pp=new ProductsPage(driver);	
		
		
		String prName = eUtil.getExcelDataUsingDataFormatter("Products", 0, 0)+jUtil.getRandomNum();
		String CampName = eUtil.getExcelDataUsingDataFormatter("Campaign", 0, 0)+jUtil.getRandomNum();
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
		
		}

	}

