package vtiger.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.ContactsInfoPage;
import POMRepository.ContactsPage;
import POMRepository.CreateContactsPage;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.OrganizationInfoPage;
import POMRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws Throwable {
		//Create object of all utility class
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		
		//Step 1: Read all the required data
		String ORGNAME = eUtil.getExcelDataUsingDataFormatter("Contacts", 4, 2)+jUtil.getRandomNum();
		String LastName = eUtil.getExcelDataUsingDataFormatter("Contacts", 4, 3);
		
		//Step 3: Navigate home page and click organization link
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		
		//Step 4: Navigate organization page
		OrganizationPage op=new OrganizationPage(driver);
		op.clickCreateOrganization();
		
		//Step 5: Navigate create organization page
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME);
		
		//Step 6: Validated for Orgnization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println("Organization created");
		System.out.println(OrgHeader);
		//Step 7: Navigate contacts link
		hp.clkContactsLnk();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickCreateContacts();
		
		//Step 8: Create contacts with Organization
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createNewContact(LastName, driver, ORGNAME);
		
		//Step 9: Validated for Contact
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeaderText();
		
		Assert.assertTrue(ContactHeader.contains(LastName));
		System.out.println("Contact created");
		System.out.println(ContactHeader);
		
	}
	@Test(groups = "SmokeSuite")
	public void demo() {
		System.out.println("Smoke Suite Printed");
	}

}
