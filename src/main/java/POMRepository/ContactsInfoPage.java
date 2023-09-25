package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class ContactsInfoPage extends WebDriverUtility {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeader;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeader() {
		return ContactHeader;
	}
	/**
	 * This method will return contact header
	 * @return
	 */
	public String getContactHeaderText() {
		return ContactHeader.getText();
	}
}