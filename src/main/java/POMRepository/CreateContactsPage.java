package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
    private WebElement OrgNameLookup;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearch;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is use for create organization
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	/**
	 * This method is use create contact with organization
	 * @param LASTNAME
	 * @param driver
	 * @param ORGNAME
	 */
	public void createNewContact(String LASTNAME,WebDriver driver,String ORGNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		OrgNameLookup.click();
		handleWindow(driver, "Accounts");
		OrgSearch.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		handleWindow(driver, "Contacts");
		SaveBtn.click();
	}
} 
