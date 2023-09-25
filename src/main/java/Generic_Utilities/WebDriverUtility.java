package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * This method is use for maximize the window
	 * @param driver
	 * @author avnish kumar
	 */
	public void maximizeWin(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will open the window in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * This method is use to wait the element for some second
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop down by index 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will help to switch the control from one window to another
	 * @param driver
	 * @author avnish kumar
	 */
	public void handleWindow(WebDriver driver,String partialWindowTitle) {
		//Step 1: Capture all the windows ids
		Set<String> allWinsId = driver.getWindowHandles();
		
		//Step 2: Navigate through each window
		for(String id:allWinsId) {
			//Step 3: Switch to each and capture the title
			String actTitle = driver.switchTo().window(id).getTitle();
			
			//Step 4: Compare te title for required
			if(actTitle.contains(partialWindowTitle)) {       // true
				break;
			}
		}
	}
	/**
	 * This method is used to scroll page to target element
	 * @param driver
	 * @param element
	 * @author avnish kumar
	 */
	public void scrollPage(WebDriver driver,WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView();", element);
	}
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 * @author avnish kumar
	 */
	public void alertAcceptPopup(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 * @author avnish kumar
	 */
	public void alertDismissPopup(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	/**
	 * This method will get the alert text and return it to caller
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to mouse hover action move to element
	 * @param driver
	 * @param element
	 * @author avnish kumar
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform right click of mouse hover
	 * @param driver
	 * @param element
	 * @author avnish kumar
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method will perform double click anywhere on the web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on a particular web element
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will used to perform drag and drop action
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	/**
	 * This method will used to perform move the cursor and click
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void moveTheCursorAndClick(WebDriver driver,int x,int y) {
		Actions a=new Actions(driver);
		a.moveByOffset(x, y).perform();
	}
	/**
	 * This method will handle frame by using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by using name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will handle frame by using webelement
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will take screenshot and store it in required folder
	 * @param driver
	 * @param screenshotName
	 * @return path
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath(); //used for extent reporting
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 }
