package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_002 {
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

	public static WebDriver driver;

	public GDSP_CustomerGUI_002(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String Usernm,com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
	
	Customer_uname.sendKeys(Usernm);
	CustomerLogin_Button.click();
	try{
		if(Invalid_Username_Message.isDisplayed())
		{
			test.log(Status.INFO,Invalid_Username_Message.getText());
			test.log(Status.PASS,"Entered user name is invalid");
			System.out.println("Entered user name is invalid");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
		}
	}
	catch(Exception e)
	{
		test.log(Status.FAIL,"Entered user name is valid");
		System.out.println("Entered user name is valid");
	}

}

}
