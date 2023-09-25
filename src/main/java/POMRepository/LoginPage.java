package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class LoginPage extends WebDriverUtility { //Rule 1- Create a seprate pom class for every web page

	//Rule 2- Identify the webelements using @FindBy,@FindBys,@FindAll
	//Declaration
	@FindBy(name = "user_name")
	private WebElement untbx;
	
	@FindBy(name = "user_password")
	private WebElement pwdtbx;
	
	@FindBy(id = "submitButton")
	private WebElement lgbtn;
	//Rule 3- Create a constructor to initialize the webelements
	//Initialization
	public LoginPage(WebDriver driver) { //if we create object of the pom page it will take the updated driver as ref
		PageFactory.initElements(driver, this);
	}
	//Rule 4- Provide getters for accessing the webelements
	//Utilization
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwdtbx() {
		return pwdtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
    //Rule 5- Provide Business liabrary
	//it is project specific genric method created using webelements present only in current page
	/**
	 * This method is use to login the application
	 * @param un
	 * @param pwd
	 */
	public void loginVtiger(String un,String pwd) {
		untbx.sendKeys(un);
		pwdtbx.sendKeys(pwd);
		lgbtn.click();
	}

}
