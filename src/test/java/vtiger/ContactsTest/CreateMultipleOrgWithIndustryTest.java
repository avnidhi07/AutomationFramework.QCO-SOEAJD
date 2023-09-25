package vtiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustryTest extends BaseClass {

	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelUtility eUtil=new ExcelUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG,String IndustryType) throws Throwable {
		
		String ORGNAME = ORG+jUtil.getRandomNum();
	
		//Step 3: Navigate to organization link
		HomePage hP=new HomePage(driver);
		hP.clickOrganizationLnk();
		
		//Step 4: click on create organization link lookup image
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickCreateOrganization();
		
		//Step 5: create organization with mandatory field
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME, IndustryType);
		//Step 6: Select "chemicals" in industry drop down
		
		//Step 7: Save
		
		//Step 8: Validate
		OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
		String orgHeader = orgInfo.getOrgHeader();
		if(orgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}

	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
}
