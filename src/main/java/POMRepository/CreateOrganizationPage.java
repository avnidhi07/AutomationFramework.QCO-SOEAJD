package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "industry")
	private WebElement clkIndustryDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement clkSave;
	
	@FindBy(name = "accounttype")
	private WebElement clkVendorDropDown;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void createNewOrganization(String ORGNAME) {
		orgName.sendKeys(ORGNAME);
		clkSave.click();
	}
	public void createNewOrganization(String ORGNAME,String Industry) {
		orgName.sendKeys(ORGNAME);
		handleDropDown(clkIndustryDropdown, Industry);
		clkSave.click();
	}
	public void createNewOrganization(String ORGNAME,String Industry,String Vendor) {
		orgName.sendKeys(ORGNAME);
		handleDropDown(clkIndustryDropdown, Industry);
		handleDropDown(clkVendorDropDown, Vendor);
		clkSave.click();
	}
}
