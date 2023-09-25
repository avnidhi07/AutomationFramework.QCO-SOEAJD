package vtiger.ProductsTest;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import POMRepository.CampaignPage;
import POMRepository.CreateCampaignPage;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.ProductsPage;

public class CreateProductWithCampaignTest extends BaseClass {
	
	ExcelUtility eUtil=new ExcelUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test
	public void createProductWithCampaignTest() throws Throwable { //https://docs.google.com/forms/d/1Eorr4JdbQbZctvvWh62-c8QIAw-6SPYY_d-uHjlB8vI/viewform?edit_requested=true
		
		String PrName = eUtil.getExcelDataUsingDataFormatter("Products", 0, 0)+jUtil.getRandomNum();
		String CampName = eUtil.getExcelDataUsingDataFormatter("Campaign", 0, 0)+jUtil.getRandomNum();
		
		HomePage hp=new HomePage(driver);
		hp.clickProductsLnk();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.clkOnCreateProductsPage();
		
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.createNewProduct(PrName);
		
		hp.moveTomore(driver);
		hp.clickCampaign();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.createCampaign();
		
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createNewCampaign(CampName, driver, PrName);
		
		
		
	}

}
