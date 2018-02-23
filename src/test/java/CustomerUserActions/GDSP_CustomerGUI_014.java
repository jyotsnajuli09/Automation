package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_014 {
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
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_userdetails;
	
public static WebDriver driver;
	
	
	public GDSP_CustomerGUI_014(WebDriver driver)
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
	public void filteruser(String username,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		Userdetails_Myaccount.click();
		filter_usernames.sendKeys(username);
		searchicon_userfilter.click();
		try
		{
			if(usertable_userdetails.getText().contains(username))
			{
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.PASS,"username filtered successfully");
				System.out.println("username filtered successfully");
			}
		}
		catch(Exception e1)
		{
			test.log(Status.FAIL,"filteration is not successful");
			System.out.println("filteration is not successful");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);

		}
			
		}
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

