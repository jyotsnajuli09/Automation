package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_012 {

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

	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public static WebElement DeleteLink_UserDetails;

	@FindBy(xpath="//input[@alt='submit']")
	public static WebElement searchIcon_UserDetails;

	@FindBy(id="overviewtable3")
	public static WebElement UserTable_UserDetails;

	@FindBy(xpath="//*[contains(text(),'NO DATA FOUND')]")
	public static WebElement NoData_UserDetails;

	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_UserDetails;

	public static WebDriver driver;

	public GDSP_PlatformGUI_012(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		test.log(Status.INFO, "Login is successfUL");

	}
	public void deleteUser( String Username,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageAccount_PlatformTab.click();
		UserAccounts_PlatformTab.click();
		Usernamesearchbox_UserDetails.sendKeys(Username);
		searchIcon_UserDetails.click();
		Thread.sleep(3000);
		try{
			if(Usertable_UserDetails.getText().contains(Username))
			{

				DeleteLink_UserDetails.click();
				Thread.sleep(8000);
				Actions act = new Actions(driver);
				act.moveToElement(popup_ok).click().build().perform();
				test.log(Status.INFO, " User has been deleted successfully");
				verifyUser(Username,tcid,test);

			}
		}
		catch(Exception e){

			test.log(Status.INFO, " User details not present on Platform");
		}
	}

	public static void verifyUser(String Username, String tcid,com.aventstack.extentreports.ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		UserAccounts_PlatformTab.click();
		Usernamesearchbox_UserDetails.sendKeys(Username);
		searchIcon_UserDetails.click();
		try{
			if(UserTable_UserDetails.getText().contains(Username))
			{
				test.log(Status.INFO, "User is still Present");
				test.log(Status.FAIL, "User has not deleted successfully");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
			}
		}

		catch(Exception e){
			{
				test.log(Status.INFO, "User is not Present");
				test.log(Status.PASS, "User has deleted successfully");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
			}
		}

	}

}



