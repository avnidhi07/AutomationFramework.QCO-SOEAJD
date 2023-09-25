package practiceTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.HomePage;
import POMRepository.ProductValidatePage;
import POMRepository.ProductsPage;

public class CreateAndDeletePr extends BaseClass {

	@Test
	public void createAndDelete() throws Throwable {
		PropertyFileUtility fUtil=new PropertyFileUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		HomePage hp=new HomePage(driver);
		hp.clickProductsLnk();
		ProductsPage pp=new ProductsPage(driver);
		
		String prName = eUtil.getExcelDataUsingDataFormatter("Products", 0, 0)+jUtil.getRandomNum();
		//pp.productsPageElement(prName);
		hp.clickProductsLnk();
		
		ProductValidatePage prVal=new ProductValidatePage(driver);
		prVal.checkProName(driver, prName);
	
		prVal.clickDelete();
		wUtil.alertAcceptPopup(driver);
		}
	@Test
	public void createContacts() {
		System.out.println("Contact created successful");
	}
	@Test
	public void createOrg() {
		System.out.println("Org created successful");
		Assert.fail();
	}
}
