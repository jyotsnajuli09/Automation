package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_012 {
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;

	@FindBy(xpath="//a[@href='account_user_details.htm?fromPage=AccountUserDetails']")
	public static WebElement Myaccount_Customer;

	@FindBy(xpath="//a[@href='account_user_edit.htm?userId=100203240&fromPage=AccountUserDetails']")
	public static WebElement edituserdetails_Myaccount;
	
	@FindBy(name="userCredentials.password")
	public static WebElement user_Password;
	
	@FindBy(name="userCredentials.passwordConfirm")
	public static WebElement user_passwordconfirm;
	
	@FindBy(id="submit")
	public static WebElement save_edituser;
	
	@FindBy(xpath="//a[@href='logout.htm?logoutType=C']")
	public static WebElement logout_user;
	
	public static WebDriver driver;
	
	
	public GDSP_CustomerGUI_012(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login( String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Customer_uname.sendKeys(Username);
		CustomerLogin_Button.click();
		Customer_Pass.sendKeys(Password);
		CustomerPassword_Button.click();
		test.log(Status.INFO, "logged in successfully");
	}
	public void edituserpassword(String username,String password,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");

		edituserdetails_Myaccount.click();

		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,450)", "");
		user_Password.sendKeys( password);
		 user_passwordconfirm.sendKeys(password);
		 save_edituser.click();
		 logout_user.click();
		 Customer_uname.sendKeys(username);
			CustomerLogin_Button.click();
			Customer_Pass.sendKeys(password);
			CustomerPassword_Button.click();
			try{
				if(driver.getPageSource().contains("Welcome"))
				{
					String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath);
					test.log(Status.PASS,"Successfully logged in and Reset password");
					System.out.println("Successfully logged in and reset password");
				}
			}
			catch(Exception e1)
			{
				test.log(Status.FAIL, "Not logged in successfully");
				System.out.println("Not logged in successfully");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);

			}
		}
		
		
		
	
	
	
	
}

























