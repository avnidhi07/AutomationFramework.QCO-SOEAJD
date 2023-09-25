package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement clkCreateContactsLookup;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClkCreateContactsLookup() {
		return clkCreateContactsLookup;
	}
	
	public void clickCreateContacts() {
		clkCreateContactsLookup.click();
	}
	
}
