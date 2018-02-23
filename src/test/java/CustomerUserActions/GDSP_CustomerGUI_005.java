package CustomerUserActions;

import genericLibrary.TakeScreenshot;
import genericLibrary.Utility_Customer;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_005 {
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;
	
	@FindBy(xpath="//*[contains(text(),'Password must not be empty')]")
	public static WebElement empty_Password_errorMessage;
	
public static WebDriver driver;
	
	public GDSP_CustomerGUI_005(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Customer_uname.sendKeys(Username);
		CustomerLogin_Button.click();
		Customer_Pass.sendKeys(Password);
		CustomerPassword_Button.click();
		
	try{
		if(empty_Password_errorMessage.isDisplayed())
		{
			test.log(Status.INFO, empty_Password_errorMessage.getText());
			test.log(Status.PASS,"user has entered Blank Password");
			System.out.println("user has entered Blank Password");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
		}}
		catch(Exception e)
		{
			test.log(Status.FAIL,"there is some internal error");
			System.out.println("there is some internal error");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			
		}

	}

}

