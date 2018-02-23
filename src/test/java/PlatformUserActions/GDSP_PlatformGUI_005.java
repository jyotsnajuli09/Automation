package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_005 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	//submit
	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//*[contains(text(),'Password must not be empty')]")
	public static WebElement empty_Password_errorMessage;

	public static WebDriver driver;

	public GDSP_PlatformGUI_005(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		try{
		if(empty_Password_errorMessage.isDisplayed())
		{
			test.log(Status.INFO, empty_Password_errorMessage.getText());
			test.log(Status.PASS,"user has entered Blank Password");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
		}}
		catch(Exception e)
		{
			test.log(Status.FAIL,"there is some internal error");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
		}

	}

}

