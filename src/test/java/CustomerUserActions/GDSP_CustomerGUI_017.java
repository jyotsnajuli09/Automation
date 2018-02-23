package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_017 {
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
	
	@FindBy(xpath="//input[@value='Create']")
	public static WebElement createuser_userdetails;
	
	@FindBy(name="user.contactName")
	public static WebElement fullusername_createuser;
	
	@FindBy(name="user.phone1")
	public static WebElement phonenumber_createuser;

	@FindBy(name="user.contactEmailAddress")
	public static WebElement email_createuser;
	
	@FindBy(name="userCredentials.password")
	public static WebElement password_createuser;
	
	@FindBy(name="userCredentials.passwordConfirm")
	public static WebElement passwordconfirm_createuser;
	
	@FindBy(name="user.userName")
	public static WebElement username_createuser;
	
	@FindBy(id="submit")
	public static WebElement save_createuser;
	
	
	@FindBy(name="formSearchValue1")
	public static WebElement filter_usernames;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_userfilter;
	
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_userdetails;
	
public static WebDriver driver;
	
	
	public GDSP_CustomerGUI_017(WebDriver driver)
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
	public void createuser(String username,String phnnum,String emailid,String password,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		Userdetails_Myaccount.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		
		createuser_userdetails.click();
		fullusername_createuser.sendKeys(username);
		phonenumber_createuser.sendKeys(phnnum);
		email_createuser.sendKeys(emailid);
		username_createuser.sendKeys(username);
		password_createuser.sendKeys(password);
		passwordconfirm_createuser.sendKeys(password);
		save_createuser.click();
		Thread.sleep(2000);
		filter_usernames.sendKeys(username);
		 searchicon_userfilter.click();
		
		try
		{
			if(usertable_userdetails.getText().contains(username))
			{
				test.log(Status.INFO, "User creation is done successfully");
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.PASS,"User creation is done successfully");
				System.out.println("User creation is done successfully");
			}
			
		}
		
		catch(Exception e)
		
		{
			test.log(Status.INFO, "User creation is not  done successfully");
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			test.log(Status.FAIL,"User creation is not  done successfully");
			System.out.println("User creation is not done successfully");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
		
}
