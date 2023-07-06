package testScripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;
import testPOM.LoginPOM;
import utilities.ReadPropertyFile;

public class LoginTest extends BaseClass{

	@Test
	public void login() throws IOException {
		
		Reporter.log("login successful",true);
		ReadPropertyFile re=new ReadPropertyFile();
		String url = re.getPropertyData("url");
		driver.get(url);
		String username=re.getPropertyData("un");
		String pwd = re.getPropertyData("pw");
		
		
		LoginPOM lp=new LoginPOM(driver);
		lp.setLogin(username, pwd);
		
	}
}
