package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_014 {
	
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;
	
	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement UserAccounts_PlatformTab;
	
	@FindBy(xpath="//input[@name='formSearchValue1']")
	public static WebElement Usernamesearchbox_UserDetails;
	
	@FindBy(xpath="//input[@alt='submit']")
	public static WebElement searchIcon_UserDetails;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_UserDetails;
	
	 public static WebDriver driver;
	
	public GDSP_PlatformGUI_014(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();

	}
	
	public void searchUser( String Username,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageAccount_PlatformTab.click();
		UserAccounts_PlatformTab.click();
		Usernamesearchbox_UserDetails.sendKeys(Username);
		searchIcon_UserDetails.click();
		Thread.sleep(3000);
		try{
		if(Usertable_UserDetails.getText().contains(Username))
		{
	
			test.log(Status.PASS, "Search for given user is available ");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
		}}
		catch(Exception e)
		{
		
			test.log(Status.FAIL, "Search for given user is not found ");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			
		}
		
		}

   }


