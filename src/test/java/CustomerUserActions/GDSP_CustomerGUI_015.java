package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_015 {
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
	
	
	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement Userdetails_Myaccount;
	
	@FindBy(name="formSearchValue1")
	public static WebElement filter_usernames;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_userfilter;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_userdetails;
	
	@FindBy(name="user.phone1")
	public static WebElement phonenumber_user;

	@FindBy(name="user.contactEmailAddress")
	public static WebElement email_user;
	
	@FindBy(id="submit")
	public static WebElement save_edituser;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_userdetails;
	
public static WebDriver driver;
	
	
	public GDSP_CustomerGUI_015(WebDriver driver)
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
	public void edituser(String username,String phnnumber,String emailid,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		Userdetails_Myaccount.click();
		filter_usernames.sendKeys(username);
		searchicon_userfilter.click();
		 Edit_userdetails.click();
		 phonenumber_user.clear();
		 phonenumber_user.sendKeys(phnnumber);
		 email_user.clear();
		 email_user.sendKeys(emailid);
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,450)", "");
		 save_edituser.click();
			
		try
		{
			if(usertable_userdetails.getText().contains(emailid))
			{
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.PASS,"user details are edited successfully");
				System.out.println("user details  are edited successfully");
			}
		}
		catch(Exception e1)
		{
			test.log(Status.FAIL,"edit of user details  are not successful");
			System.out.println("edit of user details  are not successful");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);

		}
			
		}
}
