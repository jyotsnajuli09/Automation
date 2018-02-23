package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_022 {
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
	
	@FindBy(xpath="//a[@href='manage_contact_overview.htm']")
	public static WebElement contactnames_Myaccount;
	
	
	//span[text()='Next']
	//span[text()='2']
	
	@FindBy(xpath="//span[text()='Next']")
	public static WebElement next_contactnames;
	
//	@FindBy(xpath="//span[text()='2']")
//	public static WebElement nextpage_contactnames;
	
	@FindBy(xpath="//*[@id='paginator']/tbody/tr/td[3]/span")
	public static WebElement nextpage_contactnames;
	
	public static WebDriver driver;

	public GDSP_CustomerGUI_022(WebDriver driver)
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
	public void navigatetonextpagecontactname(com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		contactnames_Myaccount.click();
		String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,450)", "");
		next_contactnames.click();
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(2000);
		System.out.println("dfghjkl;");
		try
		{
		
		if(nextpage_contactnames.isDisplayed())
		{
			test.log(Status.INFO,"nextpage displayed successfully");
			String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath1);
			System.out.println("nextpage displayed successfully");
			test.log(Status.PASS,"nextpage displayed successfully");
		}
		
}
catch(Exception e)
		
		{
	test.log(Status.INFO,"nextpage is not displayed successfully");
	System.out.println("nextpage is not displayed successfully");
	test.log(Status.PASS,"nextpage is not displayed successfully");
		}
	}
}
		
		
		
		