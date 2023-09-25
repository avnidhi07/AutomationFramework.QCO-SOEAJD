package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {

	@FindBy(name = "productname")
	private WebElement prName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement clkSavebtn;
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewProduct(String PRNAME) {
		prName.sendKeys(PRNAME);
		clkSavebtn.click();
	}
	
}
