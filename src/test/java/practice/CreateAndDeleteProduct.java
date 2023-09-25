package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.WebDriverUtility;
import POMRepository.HomePage;
import POMRepository.ProductValidatePage;
import POMRepository.ProductsPage;

public class CreateAndDeleteProduct extends BaseClass {

	@Test
	public void createAndDeleteProduct() throws Throwable {
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		/*WebDriver driver;
		String browser = fUtil.getLaunchBrowswer("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		wUtil.maximizeWin(driver);
		wUtil.implicitWait(driver);
		
		String url = fUtil.getLaunchBrowswer("url");
		String un = fUtil.getLaunchBrowswer("username");
		String pwd = fUtil.getLaunchBrowswer("pass");
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();   */
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		HomePage hp=new HomePage(driver);
		hp.clickProductsLnk();
		ProductsPage pp=new ProductsPage(driver);
		
		String prName = eUtil.getExcelDataUsingDataFormatter("Products", 1, 0)+jUtil.getRandomNum();
		//pp.productsPageElement(prName);
		//driver.findElement(By.name("productname")).sendKeys(prName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		hp.clickProductsLnk();
		
		ProductValidatePage prVal=new ProductValidatePage(driver);
		//prVal.checkProName(driver, prName);
		prVal.clickDelete();
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//a[text()='"+prName+"']/../preceding-sibling::td/input")).click();
		//pp.clickDelete();
		//driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wUtil.alertAcceptPopup(driver);
		
		
	//	List<WebElement> prList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td//a[text()='"+prName+"']"+"/../preceding-sibling::td/input")).click();
	/*	boolean flag = false;
		for(WebElement proName:prList) {
			String acData = proName.getText();
			if(acData.contains(prName)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("product data deleted");
		}
		else {
			System.out.println("product data not deleted");
		} */
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.moveToElement(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
