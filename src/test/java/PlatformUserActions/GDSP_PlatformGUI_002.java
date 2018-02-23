package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_002 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(xpath="//*[contains(text(),'Invalid user')]")
	public static WebElement Invalid_Username_Message;

	public static WebDriver driver;

	public GDSP_PlatformGUI_002(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();

		try{
			if(Invalid_Username_Message.isDisplayed())
			{
				test.log(Status.INFO,Invalid_Username_Message.getText());
				test.log(Status.PASS,"Entered user name is invalid");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);	
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Entered user name is valid");
		}

	}

}


