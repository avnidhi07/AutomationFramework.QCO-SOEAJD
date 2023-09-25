package practice_chaitramam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.OrganizationInfoPage;
import POMRepository.OrganizationPage;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//Step 1: Launch the browser
		WebDriver driver=new ChromeDriver();
		wUtil.maximizeWin(driver);
		wUtil.implicitWait(driver);
		
		//Step 2: Login to application
		pUtil.getLaunchBrowswer("browser");
		String url = pUtil.getLaunchBrowswer("url");
		String un = pUtil.getLaunchBrowswer("username");
		String pwd = pUtil.getLaunchBrowswer("pass");
		driver.get(url);
		LoginPage logPage=new LoginPage(driver);
		logPage.loginVtiger(un, pwd);
	
		//Step 3: Navigate to organization link
		HomePage hP=new HomePage(driver);
		hP.clickOrganizationLnk();
		
		//Step 4: click on create organization link lookup image
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickCreateOrganization();
		
		//Step 5: create organization with mandatory field
		String ORGNAME = eUtil.getExcelDataUsingDataFormatter("Organizations", 1, 2)+jUtil.getRandomNum();
		String IndustryType = eUtil.getExcelDataUsingDataFormatter("Organizations", 4, 3);
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
		
		//Step 9: SignOut the Apllication
		Thread.sleep(2000);
		hP.moveToSignOut(driver);
		//Step 10: Close the browser
		driver.quit();

	}

}
