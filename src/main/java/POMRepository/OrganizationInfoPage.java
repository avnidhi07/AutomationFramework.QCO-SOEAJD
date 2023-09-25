package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeader;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getOrgHeader() {
		return OrgHeader.getText();
	}
}
