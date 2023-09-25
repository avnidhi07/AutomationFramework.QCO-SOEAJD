package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class ProductValidatePage extends WebDriverUtility {

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement clkDelete;
	
	public ProductValidatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void checkProName(WebDriver driver,String prName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prName+"']"+"/../preceding-sibling::td/input")).click();
	}
	
	public void clickDelete() {
		clkDelete.click();
	}
}
