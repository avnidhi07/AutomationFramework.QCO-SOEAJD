package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.BaseClass;
import Generic_Utilities.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility {
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement ProductLookUpImage;
	
	@FindBy(id = "search_txt")
	private WebElement SearchPro;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(name = "campaignname")
	private WebElement CampName;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveBtn;
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCampaign(String CAMPNAME) {
		CampName.sendKeys(CAMPNAME);
		SaveBtn.click();
	}
	public void createNewCampaign(String CAMPNAME,WebDriver driver,String PRNAME) {
		CampName.sendKeys(CAMPNAME);
		ProductLookUpImage.click();
		handleWindow(driver, "Products&action");
		SearchPro.sendKeys(PRNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+PRNAME+"']")).click();
		handleWindow(driver, "Campaigns&action");
		SaveBtn.click();
		
	}
	
}
