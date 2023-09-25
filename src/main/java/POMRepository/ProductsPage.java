package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class ProductsPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement clkCreateProduct;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clkOnCreateProductsPage() {
		clkCreateProduct.click();
	}
	
}
