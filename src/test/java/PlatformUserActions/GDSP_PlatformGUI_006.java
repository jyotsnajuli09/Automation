package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_006 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	//submit
	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//*[contains(text(),'Invalid user')]")
	public static WebElement Invalid_Username_Message;

	@FindBy(xpath="//*[contains(text(),'Invalid password')]")
	public static WebElement Invalid_Password_Message;

	//*[contains(text(),'Due to repeated login failures, your account has been temporarily locked out')]
	@FindBy(xpath="//*[contains(text(),'Due to repeated login failures, your account has been temporarily locked out')]")
	public static WebElement Account_Locked_Message;

	public static WebDriver driver;

	public GDSP_PlatformGUI_006(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Uname, String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException 
	{
		for(int i=1;i<=3;i++)
		{
			platform_uname.clear();
			platform_uname.sendKeys(Uname);
			platformLogin_Button.click();
		}
		platform_uname.clear();
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();

		for(int i=1;i<=3;i++)
		{
			platform_Pass.clear();
			platform_Pass.sendKeys(Password);
			platformPassword_Button.click();
		}
		
		try{
			if(Account_Locked_Message.isDisplayed())
			{
				test.log(Status.INFO, Account_Locked_Message.getText());
				test.log(Status.PASS, "Account lock message has been displayed");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("try after some seconds");
			}
		}
		catch(Exception e1)
		{
			test.log(Status.FAIL, "Account lock message has not been displayed");
		}
	}

}		






