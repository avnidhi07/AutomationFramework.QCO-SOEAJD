package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement clkOrganizationLookUp;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateOrganization() {
		clkOrganizationLookUp.click();
	}
}
