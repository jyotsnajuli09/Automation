package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_016 {
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
	
	@FindBy(xpath="//a[text()='Delete']")
	public static WebElement Delete_user;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_userdetails;
	
public static WebDriver driver;
	
	
	public GDSP_CustomerGUI_016(WebDriver driver)
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
	
	public void deleteuser(String username,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		Userdetails_Myaccount.click();
		filter_usernames.sendKeys(username);
		searchicon_userfilter.click();
		Delete_user.click();
	
		 Actions act=new Actions(driver);
	 		Thread.sleep(2000);
	 		act.moveToElement(driver.findElement(By.name("ok"))).click().perform();
	 		Thread.sleep(2000);
	 		filter_usernames.sendKeys(username);
	 		searchicon_userfilter.click();
			
		try
		{
			if(usertable_userdetails.getText().contains("NO DATA FOUND"))
			{
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.PASS,"user details are deleted successfully");
				System.out.println("user details  are deleted successfully");
			}
		}
		catch(Exception e1)
		{
			test.log(Status.FAIL,"user details  are not  deleted successfully");
			System.out.println("user details  are not deleted successfully");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);

		}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
