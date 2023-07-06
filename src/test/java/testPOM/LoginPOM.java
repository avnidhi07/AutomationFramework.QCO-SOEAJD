package testPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

		
		@FindBy(id = "username")
		private WebElement untbx;
		
		@FindBy(name = "pwd")
		private WebElement pwtbx;
		
		@FindBy(id = "loginButtonContainer")
		private WebElement lgbtn;
		
		public LoginPOM(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void setLogin(String un,String pw) {
			
			untbx.sendKeys(un);
			pwtbx.sendKeys(pw);
			lgbtn.click();
		}
	
}
