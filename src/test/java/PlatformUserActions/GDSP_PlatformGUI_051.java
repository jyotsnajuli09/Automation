package PlatformUserActions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_051 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;

	@FindBy(xpath="//*[@href='manage_contact_overview.htm']")
	public static WebElement Contacts_ManageAccountTab;

	@FindBy(xpath="//*[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;

	public static WebDriver driver;

	public GDSP_PlatformGUI_051(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password)
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
	}

	public void searchContacts(com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageAccount_PlatformTab.click();
		Contacts_ManageAccountTab.click();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,4500)", ""); 
		test.log(Status.INFO,"Scroll down has been done");
		BackToTop_ManageContacts.click();	
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);

	}



}
