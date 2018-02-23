package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_004 {
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;
	
	@FindBy(xpath="//*[contains(text(),'Username must not be empty')]")
	public static WebElement empty_Username_errorMessage;
	
	public static WebDriver driver;
	
	public GDSP_CustomerGUI_004(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Customer_uname.sendKeys(Username);
		CustomerLogin_Button.click();
		
		try{
		if(empty_Username_errorMessage.isDisplayed())
		{
			test.log(Status.INFO,empty_Username_errorMessage.getText());
			test.log(Status.PASS,"user has entered Blank username");
			System.out.println("user has entered Blank username");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
		}}
		catch(Exception e)
		{
			test.log(Status.FAIL,"There is some internal Error");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("There is some internal Error");
		}
		
	}
}
