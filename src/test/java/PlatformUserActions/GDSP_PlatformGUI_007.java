package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_007 {
	
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
	
	@FindBy(xpath="//a[@href='manage_platform_ops_details_edit.htm?']")
	public static WebElement Edit_PlatformOpsDetails;
	
	@FindBy(name="platformOpsContacts.emailContactList")
	public static WebElement NotificationEventContacts_PlatformOpsDetails;
	
	@FindBy(id="submit")
	public static WebElement save_PlatformOpsDetails;
	
	public static WebDriver driver;
	
	public GDSP_PlatformGUI_007(WebDriver driver)
	{
		this.driver=driver;
	}

	public void eventEdit(String uid, String pass, ExtentTest test, String tcid) throws IOException, InterruptedException {
		platform_uname.sendKeys(uid);
		platformLogin_Button.click();
		platform_Pass.sendKeys(pass);
		platformPassword_Button.click();
		ManageAccount_PlatformTab.click();
		Edit_PlatformOpsDetails.click();
		Thread.sleep(10000);
		test.log(Status.INFO,"Edit button has been clicked successfully");
		Select dropdown = new Select(NotificationEventContacts_PlatformOpsDetails);
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
	    test.addScreenCaptureFromPath(screenShotPath2);
		dropdown.selectByIndex(5);
		Thread.sleep(3000);
		save_PlatformOpsDetails.click();
	    test.log(Status.INFO,"save has been done successfully");
	    
	}

	
	

}
