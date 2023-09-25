package vtiger.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.OrganizationInfoPage;
import POMRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_Utilities.ListenerImplementation.class)
public class CreateOrgWithIndustryAndVendorTypeTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createOrgWithIndustryAndVendorTypeTest() throws Throwable {
		//Create Object of all utility class
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String OrgName = eUtil.getExcelDataUsingDataFormatter("Organizations", 10, 2)+jUtil.getRandomNum();
		String Industry = eUtil.getExcelDataUsingDataFormatter("Organizations", 10, 3);
		String Vendor = eUtil.getExcelDataUsingDataFormatter("Organizations", 10, 4);
		
		//Step 4: Navigate home page and click organization link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		
		//Step 5: Navigate organization page
		OrganizationPage op=new OrganizationPage(driver);
		op.clickCreateOrganization();
		
		//Step 6: Navigate create organization page
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		//Assert.fail();
		cop.createNewOrganization(OrgName, Industry, Vendor);
		
		//Step 7: Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(OrgName));
		System.out.println(OrgHeader);
	}

}
