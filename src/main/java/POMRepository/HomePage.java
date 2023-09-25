package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{//Rule 1- Create a seprate pom class for every web page
	
	//Rule 2- Identify the webelements using @FindBy,@FindBys,@FindAll
	   //Declaration
    @FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
    @FindBy(linkText = "Contacts")
    private WebElement contactsLnk;
    
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
    @FindBy(linkText = "More")
    private WebElement moveMore;
    
    @FindBy(linkText = "Campaigns")
    private WebElement campaignLnk;
    
    @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement moveSignout;
    
    @FindBy(linkText = "Sign Out")
    private WebElement signoutLnk;
    
    //Rule 3- Create a constructor to initialize the webelements
  	    //Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Rule 4- Provide getters for accessing the webelements
		//Utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoveMore() {
		return moveMore;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

	public WebElement getMoveSignout() {
		return moveSignout;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	 //Rule 5- Provide Business liabrary
		//it is project specific genric method created using webelements present only in current page
	public void clickProductsLnk() {
		productsLnk.click();
	}
	public void moveTomore(WebDriver driver) {
		moveToElement(driver, moveMore);
	}
	public void clickCampaign() {
		campaignLnk.click();
	}
	public void moveToSignOut(WebDriver driver) throws Throwable {
		Thread.sleep(2000);
		moveToElement(driver, moveSignout);
		signoutLnk.click();
	}
	public void clickOrganizationLnk() {
		organizationLnk.click();
	}
	public void clkContactsLnk() {
		contactsLnk.click();
	}
	
	

}
