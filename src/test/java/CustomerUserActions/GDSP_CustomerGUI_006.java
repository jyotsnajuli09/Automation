package CustomerUserActions;

import genericLibrary.CurrentDateTime;
import genericLibrary.TakeScreenshot;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_006 
{
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;
	
	@FindBy(xpath="//*[contains(text(),'Invalid user')]")
	public static WebElement Invalid_Username_Message;

	@FindBy(xpath="//*[contains(text(),'Invalid password')]")
	public static WebElement Invalid_Password_Message;

	//*[contains(text(),'Due to repeated login failures, your account has been temporarily locked out')]
	@FindBy(xpath="//*[contains(text(),'Due to repeated login failures, your account has been temporarily locked out')]")
	public static WebElement Account_Locked_Message;

	public static WebDriver driver;

	public GDSP_CustomerGUI_006(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Uname, String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException 
	{
		for(int i=1;i<=3;i++)
		{
			Customer_uname.clear();
			Customer_uname.sendKeys(Uname);
			CustomerLogin_Button.click();
		}
		Customer_uname.clear();
		Customer_uname.sendKeys(Username);
		CustomerLogin_Button.click();

		for(int i=1;i<=3;i++)
		{
			Customer_Pass.clear();
			Customer_Pass.sendKeys(Password);
			CustomerPassword_Button.click();
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

